# import network
import time
import random
from umqtt.simple import MQTTClient
import json

# # Configuração do Wi-Fi
SSID = "Visitantes"
PASSWORD = "Wy@2023.2"

# wifi = network.WLAN(network.STA_IF)
# wifi.active(True)
# wifi.connect(SSID, PASSWORD)

# while not wifi.isconnected():
#     time.sleep(1)

# print("Wi-Fi conectado:", wifi.ifconfig())

# Configuração do MQTT
BROKER = "172.16.6.142"
PORTA = 1883
TOPICO = "iot/nodemcu"
CLIENTE_ID = "NodeMCU"

mqtt = MQTTClient(CLIENTE_ID, BROKER, PORTA)
mqtt.connect()

# Função para gerar dados simulados
def gerar_dados():
    # return '{"temperatura": ' + str(round(random.uniform(20, 30), 2)) + ', "umidade": ' + str(round(random.uniform(40, 70), 2)) + '}'
    return json.dumps({"temperatura": "10", "umidade": "20"})
# Loop para publicar os dados
# while True:
#     dados = gerar_dados()
#     mqtt.publish(TOPICO, dados)
#     print("Dados enviados via MQTT:", dados)
#     time.sleep(5)

while True:
    try:
        if not wifi.isconnected():
            print("WiFi disconnected! Reconnecting...")
            wifi.connect(SSID, PASSWORD)
            
        dados = gerar_dados()
        mqtt.publish(TOPICO, dados)
        print("Dados enviados via MQTT:", dados)
        time.sleep(5)
        
    except Exception as e:
        print("Error:", e)
        time.sleep(10)
        # Reset the MQTT connection
        mqtt.connect()