# 📌 Exemplo de Requisição POST Usando Flask

## 1️⃣ Como o Flask Funciona?

✅ Flask cria um servidor web que recebe e processa requisições HTTP.<br>
✅ Suporta GET, POST, PUT, DELETE, permitindo manipular dados remotamente.<br>
✅ Fácil integração com bancos de dados, autenticação e APIs REST.<br>
✅ Pode ser executado localmente ou hospedado na nuvem (ex: Google Colab).


## 2️⃣ Principais Funcionalidades do Flask

|   **Funcionalidade**  	|                 **Descrição**                	|               **Exemplo**               	|
|:---------------------:	|:--------------------------------------------:	|:---------------------------------------:	|
| Rotas (@app.route)    	| Define URLs acessíveis na API                	| @app.route('/sensor', methods=['POST']) 	|
| Requisições (request) 	| Lê dados enviados pelo cliente (ex: NodeMCU) 	| request.json                            	|
| Respostas (jsonify)   	| Retorna dados formatados como JSON           	| return jsonify({"status": "ok"})        	|
| Debug Mode            	| Atualiza o servidor automaticamente          	| app.run(debug=True)                     	|
------------
</br>

📌 Exemplo: Criando um Servidor Flask com Requisição POST
```python
from flask import Flask, request, jsonify

app = Flask(__name__)  # Criando a API Flask

# Rota para receber dados do NodeMCU
@app.route('/sensor', methods=['POST'])
def receber_dados():
    dados = request.json  # Lê os dados JSON enviados pelo NodeMCU
    print("Dados recebidos:", dados)  # Exibe os dados no terminal
    return jsonify({"status": "sucesso", "dados": dados}), 200  # Retorna resposta JSON

# Iniciar o servidor Flask
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
```

⸻

## 3️⃣ Explicação do Código

📌 Passo a Passo do Funcionamento
1.	Importação de bibliotecas
- Flask: Cria o servidor.
- request: Lê os dados enviados pelo NodeMCU.
- jsonify: Retorna uma resposta em formato JSON.
2.	Definição da rota /sensor
- Aceita requisições POST para receber dados.
- request.json lê o JSON enviado pelo NodeMCU.
3.	Resposta ao cliente
- Retorna um JSON confirmando o recebimento dos dados (status: sucesso).
- Código HTTP 200, indicando sucesso na requisição.


## 4️⃣ Testando a API com um Cliente HTTP

Podemos testar a API antes do NodeMCU, usando Postman ou Python.

📌 Teste com Python (requests)
```python
import requests

url = "http://127.0.0.1:5000/sensor"  # URL do servidor Flask
dados = {"temperatura": 25.5, "umidade": 60.0}

response = requests.post(url, json=dados)  # Envia os dados
print("Resposta do servidor:", response.json())  # Exibe a resposta

📌 Teste com curl no terminal

curl -X POST "http://127.0.0.1:5000/sensor" -H "Content-Type: application/json" -d '{"temperatura": 25.5, "umidade": 60.0}'
```

🔹 5️⃣ Como o NodeMCU Envia Dados para o Flask

Agora, vamos configurar o NodeMCU (ESP8266/ESP32) para enviar dados ao Flask.

📌 Código MicroPython para o NodeMCU
```python
import network
import urequests
import time

# Configuração do Wi-Fi
SSID = "NOME_DA_REDE"
PASSWORD = "SENHA_DA_REDE"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(SSID, PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Wi-Fi conectado:", wifi.ifconfig())

# URL do servidor Flask (alterar para o IP correto)
SERVER_URL = "http://192.168.1.100:5000/sensor"

# Envio de dados simulados
dados = {"temperatura": 24.8, "umidade": 58.2}
response = urequests.post(SERVER_URL, json=dados)

print("Resposta do servidor:", response.text)
````

**📌 Explicação**
✅ Conecta o NodeMCU ao Wi-Fi.<br>
✅ Envia dados JSON via HTTP POST para o servidor Flask.<br>
✅ Exibe a resposta recebida do servidor.


### 📌 Referências Oficiais
- Flask Docs: https://flask.palletsprojects.com/
- Python Requests: https://docs.python-requests.org/

