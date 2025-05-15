import network
import urequests
import time
import random
from datetime import datetime


# Configuração do Wi-Fi
SSID = "Visitantes"  # Substitua pelo seu SSID
PASSWORD = "Wy@2023.2"  # Substitua pela sua senha

# URL do servidor Flask
SERVER_URL = "http://172.16.6.142:3000/api/data"

# ID do grupo para este dispositivo
GROUP_ID = "Teacher"

def verificar_conexao_wifi():
    """Verifica se a conexão WiFi está ativa e tenta reconectar se necessário"""
    wifi = network.WLAN(network.STA_IF)
    
    if not wifi.isconnected():
        print("WiFi desconectado. Tentando reconectar...")
        wifi.active(True)
        wifi.connect(SSID, PASSWORD)
        
        # Tenta conectar por até 10 segundos
        for _ in range(10):
            if wifi.isconnected():
                print("WiFi reconectado com sucesso!")
                print("Configuração de rede:", wifi.ifconfig())
                return True
            time.sleep(1)
        
        print("Falha ao reconectar ao WiFi")
        return False
    
    return True


# Função para gerar dados simulados
def gerar_dados():
    timestamp = datetime.now().isoformat()
    return {
        "group_id": GROUP_ID,
        "sensor_type": "temperature",
        "value": "100"
    }

# Loop para enviar dados
while True:
    # Verifica a conexão WiFi antes de tentar enviar dados
    # if not verificar_conexao_wifi():
    #     print("Aguardando 5 segundos antes de tentar novamente...")
    #     time.sleep(5)
    #     continue

    dados = gerar_dados()
    try:
        response = urequests.post(SERVER_URL, json=dados)
        print("Dados enviados:", dados)
        print("Resposta do servidor:", response.text)
        response.close()  # É importante fechar a resposta para liberar recursos
    except Exception as e:
        print("Erro ao enviar:", e)

    time.sleep(10)

# dados = {"group_id": "Teacher", "sensor_type": "temperature", "value": "100"}

