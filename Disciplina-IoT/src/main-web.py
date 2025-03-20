#import socket
from machine import Pin, I2C
from BME280 import BME280
from time import sleep

# Configuração do sensor I2C (GPIO5=D1 e GPIO4=D2)
i2c = I2C(scl=Pin(5), sda=Pin(4))
sensor = BME280(i2c=i2c)

# Calcula altitude com base na pressão padrão ao nível do mar (1013.25 hPa)


# Criação do servidor HTTP
# Servidor HTTP



while True:
    temp = sensor.read_temperature() / 100  # °C
    hum = sensor.read_humidity() / 1024   # %
    press = sensor.read_pressure() / 25600  # hPa
    alt = 44330 * (1 - (press / 1013.25)**0.1903)  # altitude em metros
    
    print("Temperatura atual: %.2f \ºC\nHumidade do Ar: %.2f \%\nPressão atmosférica: %.2f hPa\nAltitude: %.2f m"%(temp, hum, press, alt))

#         html = f"""HTTP/1.1 200 OK
# Content-Type: text/html
# <!DOCTYPE html>
# <html lang="pt-BR">
# <head>
#   <meta charset="UTF-8">
#   <title>Sensor BME280 - UniRuy</title>
#   <meta http-equiv="refresh" content="5">
#   <style>
#     body {
#       background-color: #F2F5FC;
#       color: #223A70;
#       display: flex;
#       flex-direction: column;
#       align-items: center;
#       justify-content: center;
#       margin: 0;
#       padding: 20px;
#     }
#     header {
#       text-align: center;
#       margin-bottom: 20px;
#     }
#     .logo {
#       width: 120px;
#       height: auto;
#     }
#     .card {
#       background-color: #FFFFFF;
#       padding: 20px;
#       border-radius: 10px;
#       box-shadow: 0 4px 12px rgba(34, 58, 112, 0.2);
#       width: 300px;
#       text-align: left;
#     }
#     ul {
#       list-style: none;
#       padding: 0;
#     }
#     li {
#       margin: 10px 0;
#       font-size: 1.1em;
#     }
#   </style>
# </head>
# <body>
#   <header>
#     <img class="logo" src="https://media.licdn.com/dms/image/v2/C4D0BAQF6le74Y94How/company-logo_200_200/company-logo_200_200/0/1633358789629/uniruy_logo?e=1750291200&v=beta&t=8ceG9DBv2cz4OPNaU0MOJ-TEE68UIA2UrC5EuN31V1U" alt="UniRuy Logo">
#     <h2>Dados Atuais do Sensor BME280</h2>
#   </header>
# 
#   <div class="card">
#     <ul>
#       <li>🌡️ Temperatura: {temp:.2f} °C</li>
#       <li>💧 Umidade: {hum:.2f} %</li>
#       <li>📌 Pressão: {press:.2f} hPa</li>
#       <li>🏔️ Altitude: {alt:.2f} m</li>
#     </ul>
#   </div>
# 
# </body>
# </html>
# """
#         conn.send(html)
#     except Exception as e:
#         print('Erro:', e)
#     finally:
#         conn.close()