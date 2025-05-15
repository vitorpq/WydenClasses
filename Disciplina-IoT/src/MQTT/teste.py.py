import paho.mqtt.client as paho
from paho import mqtt
import base64
import time

# --- Configurações ---
pdf_file_path = 'caminho/para/seu/arquivo.pdf'  # Coloque o caminho correto do seu PDF
mqtt_broker_address = "SEU_BROKER_HIVEMQ_ADDRESS.s1.eu.hivemq.cloud" # EX: abcde12345.s1.eu.hivemq.cloud
mqtt_port = 8883  # Porta TLS padrão do HiveMQ Cloud
mqtt_username = "SEU_USUARIO_HIVEMQ"
mqtt_password = "SUA_SENHA_HIVEMQ"
mqtt_topic = "testes/arquivos/base64" # Tópico para publicar

# --- Funções de Callback (Opcional, mas útil para depuração) ---
def on_connect(client, userdata, flags, rc, properties=None):
    if rc == 0:
        print("Conectado ao Broker MQTT com sucesso!")
    else:
        print(f"Falha na conexão, código de retorno: {rc}")

def on_publish(client, userdata, mid, properties=None):
    print(f"Mensagem (MID: {mid}) publicada.")

# --- Leitura e Codificação do Arquivo ---
try:
    with open(pdf_file_path, 'rb') as pdf_file:
        binary_content = pdf_file.read()
        base64_bytes = base64.b64encode(binary_content)
        base64_string = base64_bytes.decode('utf-8') # Decodifica para string UTF-8
        print(f"Arquivo '{pdf_file_path}' lido e codificado em Base64.")
        # print("Preview Base64 (primeiros 100 chars):", base64_string[:100]) # Descomente para ver
except FileNotFoundError:
    print(f"Erro: Arquivo não encontrado em '{pdf_file_path}'")
    exit()
except Exception as e:
    print(f"Erro ao ler ou codificar o arquivo: {e}")
    exit()

# --- Conexão e Publicação MQTT ---
client = paho.Client(client_id="", userdata=None, protocol=paho.MQTTv5)
client.on_connect = on_connect
client.on_publish = on_publish

# Configurar TLS (Necessário para HiveMQ Cloud)
client.tls_set(tls_version=mqtt.client.ssl.PROTOCOL_TLS)

# Configurar usuário e senha
client.username_pw_set(mqtt_username, mqtt_password)

# Conectar ao broker
try:
    client.connect(mqtt_broker_address, mqtt_port)
except Exception as e:
    print(f"Erro ao conectar ao broker MQTT: {e}")
    exit()

# Iniciar o loop de rede em outra thread para processar callbacks
client.loop_start()

# Publicar a mensagem com o conteúdo Base64
msg_info = client.publish(mqtt_topic, payload=base64_string, qos=1) # QoS 1 para garantir entrega
msg_info.wait_for_publish() # Espera a confirmação da publicação

print(f"Payload Base64 enviado para o tópico '{mqtt_topic}'.")

# Parar o loop e desconectar
client.loop_stop()
client.disconnect()
print("Desconectado do Broker MQTT.")