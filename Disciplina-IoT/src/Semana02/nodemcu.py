import requests

url = "http://127.0.0.1:3000/sensor"  # URL do servidor Flask
dados = {"temperatura": 25.5, "umidade": 60.0}

response = requests.post(url, json=dados)  # Envia os dados
print("Resposta do servidor:", response.json())  # Exibe a resposta
