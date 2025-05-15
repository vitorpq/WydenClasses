# --- Bibliotecas MicroPython ---
import network
import utime
from umqtt.simple import MQTTClient
import ujson # MicroPython JSON module
import usys
# import ubinascii # Pode ser útil para gerar Client ID

# --- Configurações Wi-Fi ---
WIFI_SSID = "NOME_DA_SUA_REDE_WIFI"
WIFI_PASSWORD = "SENHA_DA_SUA_REDE_WIFI"

# --- Informações que o aluno precisa fornecer ---
student_id = "matricula_micropython" # <<-- IDENTIFICADOR ÚNICO DO ALUNO
file_download_link = "https://link_seguro_para_o_arquivo_do_aluno_MP.com/abc" # <<-- LINK OBTIDO APÓS UPLOAD
original_filename = "Trabalho_MP.pdf" # <<-- Nome original do arquivo
file_size_bytes = 50000 # <<-- Tamanho do arquivo em bytes
file_hash_sha256 = "f0e1d2c3..." # <<-- Hash SHA256 do arquivo (recomendado)
# --- Fim das informações do aluno ---

# --- Configurações MQTT ---
# Use um Client ID único, pode incluir parte do ID do dispositivo ou timestamp
# client_id = ubinascii.hexlify(network.WLAN(network.STA_IF).config('mac'),':').decode() + str(utime.time())
client_id = f"upy-{student_id}-{utime.time_ns()}" # Exemplo de Client ID único
mqtt_broker = "SEU_BROKER_HIVEMQ_ADDRESS.sX.cloud.hivemq.cloud" # <<-- SEU ENDEREÇO AQUI
mqtt_port = 8883 # Porta TLS padrão
mqtt_user = "SEU_USUARIO_HIVEMQ_ALUNO_MP" # <<-- SEU USUÁRIO AQUI
mqtt_password = "SUA_SENHA_HIVEMQ_ALUNO_MP" # <<-- SUA SENHA AQUI
mqtt_topic = f"trabalhos/submissoes/{student_id}" # Tópico específico do aluno
# --- Fim das Configurações MQTT ---

# --- Função para Conectar ao Wi-Fi ---
def connect_wifi(ssid, password):
    sta_if = network.WLAN(network.STA_IF)
    if not sta_if.isconnected():
        print('Conectando ao WiFi...')
        sta_if.active(True)
        sta_if.connect(ssid, password)
        # Espera pela conexão
        max_wait = 15
        while not sta_if.isconnected() and max_wait > 0:
            print('.', end='')
            utime.sleep(1)
            max_wait -= 1

    if sta_if.isconnected():
        print('\nConectado! Configurações de rede:', sta_if.ifconfig())
        return True
    else:
        print('\nFalha ao conectar ao WiFi')
        return False

# --- Lógica Principal ---

# 1. Conectar ao Wi-Fi
if not connect_wifi(WIFI_SSID, WIFI_PASSWORD):
    print("Não foi possível conectar ao Wi-Fi. Saindo.")
    usys.exit() # Ou trate o erro como preferir

# 2. Preparar Payload JSON
metadata_payload = {
    "student_id": student_id,
    "original_filename": original_filename,
    "file_size_bytes": file_size_bytes,
    "file_hash_sha256": file_hash_sha256,
    "download_link": file_download_link,
    "submission_timestamp_utc": utime.gmtime() # Timestamp UTC (formato pode variar)
    # Considerar formatar o timestamp como ISO 8601 se possível/necessário
}

# Converte para string JSON
try:
    json_payload_str = ujson.dumps(metadata_payload)
    # Codifica para bytes (necessário para umqtt.simple.publish)
    json_payload_bytes = json_payload_str.encode('utf-8')
    print("Payload JSON preparado (bytes):", json_payload_bytes[:100], "...") # Mostra início
except Exception as e:
    print(f"Erro ao criar JSON: {e}")
    usys.exit()

# 3. Configurar e Conectar Cliente MQTT
print(f"Conectando ao Broker MQTT: {mqtt_broker}")
mqtt_client = None
try:
    # Instanciar o cliente MQTT com TLS
    mqtt_client = MQTTClient(client_id=client_id,
                             server=mqtt_broker,
                             port=mqtt_port,
                             user=mqtt_user,
                             password=mqtt_password,
                             keepalive=60,
                             ssl=True, # Habilitar SSL/TLS
                             ssl_params={}) # Parâmetros SSL padrão geralmente funcionam

    mqtt_client.connect() # Tenta conectar
    print("Conectado ao MQTT com sucesso!")

except OSError as e:
    print(f"Erro de conexão MQTT (OSError): {e}")
    # Poderia tentar reconectar ou sair
    usys.exit()
except Exception as e:
    print(f"Erro inesperado na configuração/conexão MQTT: {e}")
    if mqtt_client:
        try:
            mqtt_client.disconnect() # Tenta desconectar se o objeto foi criado
        except:
            pass
    usys.exit()


# 4. Publicar a Mensagem (com QoS 0)
try:
    print(f"Publicando no tópico '{mqtt_topic}' (QoS 0)...")
    # IMPORTANTE: umqtt.simple geralmente só suporta QoS 0 confiavelmente.
    mqtt_client.publish(topic=mqtt_topic, msg=json_payload_bytes, retain=False, qos=0)
    print("Mensagem publicada (QoS 0 - sem garantia de entrega).")

except Exception as e:
    print(f"Erro ao publicar mensagem: {e}")
    # O estado da conexão pode ser incerto aqui

# 5. Desconectar
try:
    print("Desconectando do MQTT...")
    mqtt_client.disconnect()
    print("Desconectado.")
except Exception as e:
    print(f"Erro ao desconectar: {e}")