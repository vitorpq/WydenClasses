import network
import time
# Configuração do Wi-Fi
SSID = "MiniTooth"
PASSWORD = "hfr230211619"

wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(SSID, PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Wi-Fi conectado:", wifi.ifconfig())
