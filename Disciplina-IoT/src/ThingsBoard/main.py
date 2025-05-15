import urequests
import ujson
import time
import urandom



# Token do dispositivo no ThingsBoard
ACCESS_TOKEN = 'yogK6fl2HqKw28mntVb4'

# Endpoint HTTP do ThingsBoard
url = 'https://thingsboard.cloud/api/v1/{}/telemetry'.format(ACCESS_TOKEN)
headers = {'Content-Type': 'application/json'}

while True:
    # Geração aleatória dos valores
    temperatura = 20 + urandom.getrandbits(4)  # entre 20 e 35 (aproximadamente)
    umidade = 40 + urandom.getrandbits(5)      # entre 40 e 71 (aproximadamente)

    payload = {
        'temperature': temperatura,
        'humidity': umidade
    }

    try:
        response = urequests.post(url, headers=headers, data=ujson.dumps(payload))
        print('Enviado:', payload, '| Status:', response.status_code)
        response.close()
    except Exception as e:
        print('Erro ao enviar:', e)

    time.sleep(10)  # Espera 10 segundos para o próximo envio