📌 Tópicos e Conceitos HTTP e MQTT em IoT

⸻

🔹 1️⃣ Tópicos sobre HTTP na IoT

📌 O que é HTTP?

✅ Definição: HTTP (HyperText Transfer Protocol) é um protocolo de comunicação utilizado para troca de dados na web.</br>
✅ Uso na IoT: Dispositivos IoT utilizam requisições HTTP para enviar dados para servidores na nuvem.

📌 Referência: [Mozilla HTTP Docs](https://developer.mozilla.org/en-US/docs/Web/HTTP)

⸻

📌 Estrutura de uma Requisição HTTP

📌 Métodos mais usados na IoT:

| Método |             Descrição            |           Exemplo de Uso           |
|:------:|:--------------------------------:|:----------------------------------:|
| GET    | Obtém informações de um servidor | Buscar dados do sensor             |
| POST   | Envia dados para o servidor      | Enviar leitura do NodeMCU para API |
| PUT    | Atualiza um recurso no servidor  | Modificar configuração do NodeMCU  |
| DELETE | Remove um recurso                | Apagar dados no servidor           |


📌 Exemplo de requisição POST em Python:
```python
import requests

url = "https://meuservidor.com/dados"
dados = {"temperatura": 25.5, "umidade": 60}

response = requests.post(url, json=dados)
print(response.text)
```
📌 Referência: [HTTP Methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Methods)

⸻

📌 Como um Dispositivo IoT Usa HTTP

📌 Fluxo de funcionamento:
	1.	O NodeMCU coleta os dados do sensor.
	2.	O NodeMCU faz uma requisição HTTP para enviar os dados para um servidor na nuvem.
	3.	O servidor responde, confirmando que os dados foram recebidos.

📌 Desafios do HTTP na IoT:
✅ Alto consumo de energia 🡆 HTTP não é eficiente para dispositivos com bateria.
✅ Latência 🡆 Cada requisição gera um atraso.

📌 Referência: [HTTP vs MQTT for IoT](https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.hivemq.com/blog/mqtt-vs-http-protocols-in-iot-iiot/&ved=2ahUKEwiQzJaxzpiMAxUFqZUCHeanILQQFnoECCQQAQ&usg=AOvVaw2ZY7_hg8ymPcm98hsthnkQ)

⸻

🔹 2️⃣ Tópicos sobre MQTT na IoT

📌 O que é MQTT?

✅ Definição: MQTT (Message Queuing Telemetry Transport) é um protocolo leve projetado para comunicação eficiente em redes de IoT.</br>
✅ Diferença para HTTP: Enquanto o HTTP precisa de requisições diretas, o MQTT usa um modelo de publicação e assinatura (publish/subscribe), que reduz tráfego e consumo de energia.

📌 Referência: [MQTT.org](https://mqtt.org/getting-started/)

⸻

📌 Arquitetura MQTT

📌 Componentes principais:

|      Componente      |                                Descrição                               |
|:--------------------:|:----------------------------------------------------------------------:|
| Cliente (Publisher)  | O dispositivo que envia dados (ex: NodeMCU)                            |
| Broker               | O servidor que recebe e distribui as mensagens (ex: Mosquitto, HiveMQ) |
| Cliente (Subscriber) | O dispositivo que recebe os dados (ex: Dashboard, outro NodeMCU)       |

📌 Referência: [MQTT Essentials](https://mqtt.org/getting-started/)

⸻

📌 Modelo Publish/Subscribe

📌 Como funciona?
	1.	O NodeMCU publica (publish) uma mensagem no tópico iot/dados.
	2.	O broker MQTT (HiveMQ, Mosquitto, etc.) recebe a mensagem.
	3.	Qualquer cliente que assina (subscribe) o tópico recebe a mensagem.

📌 Exemplo de Publicação MQTT em Python:
```python
import paho.mqtt.client as mqtt

broker = "broker.hivemq.com"
topico = "iot/dados"

cliente = mqtt.Client()
cliente.connect(broker, 1883)
cliente.publish(topico, '{"temperatura": 25.5, "umidade": 60}')
```
📌 Referência: [Paho MQTT Docs](https://www.emqx.com/en/blog/how-to-use-mqtt-in-python)

⸻

📌 Vantagens do MQTT na IoT

✅ Baixo consumo de energia 🡆 Ideal para dispositivos IoT.</br>
✅ Menos latência 🡆 Envio e recebimento rápido.</br>
✅ Suporte a comunicação contínua 🡆 Útil para monitoramento em tempo real.

📌 Referência: [MQTT vs HTTP](https://www.hivemq.com/blog/mqtt-vs-http-protocols-in-iot-iiot/%26hl%3Dpt%26sl%3Den%26tl%3Dpt%26client%3Dsrp%26prev%3Dsearch&ved=2ahUKEwjtqaDnzpiMAxXNq5UCHdcgPc8QFnoECBYQAQ&usg=AOvVaw1gZH672yJ0LR9Y6TxqJGgh)

⸻

🔹 3️⃣ Comparação HTTP vs MQTT na IoT

|   Característica   |                HTTP                |                MQTT                |
|:------------------:|:----------------------------------:|:----------------------------------:|
| Modelo             | Requisição/Resposta                | Publish/Subscribe                  |
| Conexão            | Temporária (abre e fecha conexões) | Permanente (mantém conexão aberta) |
| Consumo de Energia | Alto                               | Baixo                              |
| Latência           | Maior                              | Menor                              |
| Quando usar?       | Comunicação pontual                | Comunicação contínua               |

📌 Referência: [DZone IoT Protocols](https://dzone.com/articles/explore-the-complete-guide-to-iot-protocols)

⸻

📌 Links de Referência:
- HTTP for IoT - https://developer.mozilla.org/en-US/docs/Web/HTTP
- MQTT for IoT - https://mqtt.org
- Mosquitto Broker - https://mosquitto.org
- HiveMQ Broker - https://www.hivemq.com
- Flask API - https://flask.palletsprojects.com

