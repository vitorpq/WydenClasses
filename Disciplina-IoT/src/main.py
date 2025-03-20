import network
import urequests
import time
import random

# Configuração do Wi-Fi
SSID = "Visitantes"  # Substitua pelo seu SSID
PASSWORD = "Wy@2023.2"  # Substitua pela sua senha

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(SSID, PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Wi-Fi conectado:", wifi.ifconfig())

# URL do servidor Flask (certifique-se de que o Localtunnel esteja rodando e esta URL esteja correta)
SERVER_URL = "http://172.16.6.142:3000/dados"  # Substitua pela URL fornecida pelo Localtunnel

# Função para gerar dados simulados
def gerar_dados():
    return {
        "temperatura": round(random.uniform(20, 30), 2),
        "umidade": round(random.uniform(40, 70), 2)
    }

# Loop para enviar dados
while True:
    dados = gerar_dados()
    try:
        response = urequests.post(SERVER_URL, json=dados)
        print("Resposta do servidor:", response.text)
        response.close()  # É importante fechar a resposta para liberar recursos
    except Exception as e:
        print("Erro ao enviar:", e)

    time.sleep(5)