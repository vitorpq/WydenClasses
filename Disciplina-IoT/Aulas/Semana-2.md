# 📌 Aula 2 - Protocolos de Comunicação (HTTP e MQTT)

## 🎯 Objetivo:
- Ensinar os conceitos de HTTP e MQTT.
- Mostrar como enviar dados simulados do NodeMCU para um servidor Flask via HTTP e para um broker MQTT.
- Fornecer materiais para que os alunos possam implementar sozinhos.

⸻

## 📌 1️⃣ Estrutura da Aula

1. Introdução aos protocolos HTTP e MQTT
2. Explicação detalhada do HTTP e implementação com Flask
3. Explicação detalhada do MQTT e configuração do broker Mosquitto
4. Demonstração de envio de dados simulados do NodeMCU via HTTP e MQTT

⸻

## 📌 2️⃣ Conteúdo Teórico

### 🛜 O que são HTTP e MQTT?

HTTP e MQTT são protocolos de comunicação usados para a troca de dados entre dispositivos IoT e servidores na nuvem.

Protocolo	Características
HTTP (HyperText Transfer Protocol)	Usa o modelo requisição-resposta, ideal para envio de dados pontuais
MQTT (Message Queuing Telemetry Transport)	Baseado em publish/subscribe, ideal para comunicação contínua e em tempo real

📌 Casos de Uso:
- HTTP: Enviar leituras de sensores para uma API na nuvem.
- MQTT: Monitorar sensores continuamente e reagir a eventos.

🔗 Referências:
- HTTP: https://developer.mozilla.org/en-US/docs/Web/HTTP
- MQTT: https://mqtt.org/

#### 📌 3️⃣ Implementação com HTTP

📌 Passos para os alunos:
1. Criar um servidor Flask no Google Colab.
2. Programar o NodeMCU para enviar dados via HTTP POST.

**🖥️ Criando o Servidor Flask no Google Colab**

📌 Código para rodar no Google Colab:
```python
!pip install flask flask-ngrok

from flask import Flask, request, jsonify
from flask_ngrok import run_with_ngrok

app = Flask(__name__)
run_with_ngrok(app)  # Permite acesso externo

@app.route('/dados', methods=['POST'])
def receber_dados():
    dados = request.json
    print("Dados recebidos:", dados)
    return jsonify({"status": "sucesso", "dados": dados}), 200

app.run()
```
🔗 Referências:
- Flask: https://flask.palletsprojects.com/
- Flask + Google Colab: https://medium.com/analytics-vidhya/using-google-colab-to-create-and-run-a-flask-app-73f8c3679a5e

⸻

#### 📡 Enviando Dados Simulados via HTTP no NodeMCU

📌 Código MicroPython para enviar dados para o Flask
```python
import network
import urequests
import time
import random

# Configuração do Wi-Fi
SSID = "Visitantes"
PASSWORD = "Wyu@23.2"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(SSID, PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Wi-Fi conectado:", wifi.ifconfig())

# URL do servidor Flask no Google Colab
SERVER_URL = "https://xyz.ngrok.io/dados"

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
    except Exception as e:
        print("Erro ao enviar:", e)
    
    time.sleep(5)
```
**📌 O que esse código faz?**

✅ Conecta o NodeMCU ao Wi-Fi.</br>
✅ Gera dados simulados.</br>
✅ Envia dados JSON via HTTP POST para o Flask no Google Colab.

⸻

### 📌 4️⃣ Implementação com MQTT

📌 Passos para os alunos:
1. Configurar um broker MQTT gratuito.
2. Publicar dados simulados do NodeMCU via MQTT.


#### 🌍 Usando um Broker MQTT Gratuito

Usaremos o broker público da HiveMQ.

📌 Configuração do Broker MQTT:
- Broker: broker.hivemq.com
- Porta: 1883
- Tópico: iot/nodemcu

🔗 Referências:
- Broker público HiveMQ: https://www.hivemq.com/public-mqtt-broker/
- Documentação MQTT: https://mqtt.org/documentation/

⸻

#### 📡 Publicando Dados Simulados no MQTT via NodeMCU

📌 Código MicroPython para MQTT
```python
import network
import time
import random
from umqtt.simple import MQTTClient

# Configuração do Wi-Fi
SSID = "NOME_DA_REDE"
PASSWORD = "SENHA_DA_REDE"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(SSID, PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Wi-Fi conectado:", wifi.ifconfig())

# Configuração do MQTT
BROKER = "broker.hivemq.com"
PORTA = 1883
TOPICO = "iot/nodemcu"
CLIENTE_ID = "NodeMCU"

mqtt = MQTTClient(CLIENTE_ID, BROKER, PORTA)
mqtt.connect()

# Função para gerar dados simulados
def gerar_dados():
    return '{"temperatura": ' + str(round(random.uniform(20, 30), 2)) + ', "umidade": ' + str(round(random.uniform(40, 70), 2)) + '}'

# Loop para publicar os dados
while True:
    dados = gerar_dados()
    mqtt.publish(TOPICO, dados)
    print("Dados enviados via MQTT:", dados)
    time.sleep(5)
```
**📌 O que esse código faz?**

✅ Conecta o NodeMCU ao Wi-Fi.</br>
✅ Configura o broker MQTT (HiveMQ).</br>
✅ Publica dados JSON simulados no tópico MQTT iot/nodemcu.

**📌 5️⃣ Testando a Comunicação MQTT**

Para monitorar as mensagens enviadas pelo NodeMCU, use:
1.	Acesse o HiveMQ Web Client:
🔗 http://www.hivemq.com/demos/websocket-client/
2.	Inscreva-se no tópico iot/nodemcu.
3.	Veja os dados chegando em tempo real.
