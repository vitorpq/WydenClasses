from camera import Camera, PixelFormat, FrameSize
import network
import socket
import time
import gc  # Importação do Garbage Collector


# Configurações do Wi-Fi
ssid = "CEO-3f"
password = "drive_ARHAT_shave"

# Inicializa a câmera (configuração para ESP32-CAM AI-Thinker)
cam = Camera(pixel_format=PixelFormat.RGB565)
cam.init()


print("📸 Câmera inicializada com sucesso!")

station = network.WLAN(network.STA_IF)
station.active(True)
station.connect(ssid, password)

print("📶 Conectando ao Wi-Fi...")
while not station.isconnected():
    time.sleep(0.5)

print('✅ Conectado:', station.ifconfig())

# SERVIDOR WEB MJPEG com otimização GC
def mjpeg_stream(conn):
    boundary = 'frame'
    conn.send('HTTP/1.0 200 OK\r\n'
              'Content-Type: multipart/x-mixed-replace; boundary=%s\r\n\r\n' % boundary)
    try:
        while True:
            time.sleep(0.2)
            buf = cam.capture()
            conn.send('--%s\r\n' % boundary)
            conn.send('Content-Type: image/jpeg\r\n')
            conn.send('Content-Length: %d\r\n\r\n' % len(buf))
            conn.send(buf)
            conn.send('\r\n')
            
            gc.collect()  # Libera memória após cada captura
            time.sleep(0.1)
    except Exception as e:
        print('❌ Conexão encerrada:', e)
        gc.collect()

def web_server():
    addr = socket.getaddrinfo('0.0.0.0', 80)[0][-1]
    s = socket.socket()
    s.bind(addr)
    s.listen(1)

    print('🌐 Servidor rodando em:', addr)

    while True:
        conn, addr = s.accept()
        print('🔗 Cliente conectado:', addr)
        request = conn.recv(1024)

        if b'GET / ' in request:
            html = """<!DOCTYPE html>
<html>
<head><title>ESP32-CAM Stream</title></head>
<body><h1>ESP32-CAM Livestream</h1>
<img src="/stream">
</body>
</html>"""
            conn.send('HTTP/1.0 200 OK\r\nContent-type: text/html\r\n\r\n')
            conn.sendall(html)
            conn.close()
            gc.collect()  # Limpa após enviar página

        elif b'GET /stream' in request:
            mjpeg_stream(conn)
            conn.close()
            gc.collect()

        else:
            conn.send('HTTP/1.0 404 NOT FOUND\r\n\r\n')
            conn.close()
            gc.collect()

try:
    web_server()
except KeyboardInterrupt:
    print("🚫 Servidor encerrado pelo usuário.")
finally:
    cam.deinit()
    gc.collect()  # Limpeza final de memória