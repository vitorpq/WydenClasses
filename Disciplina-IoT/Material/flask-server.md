Vamos criar um servidor Flask simples para receber dados dos NodeMCUs dos alunos via HTTP.
Este servidor permitirá que os alunos enviem dados de seus sensores e verifiquem se a conexão está funcionando corretamente.

---

### **1. Estrutura do Servidor Flask**

#### **Arquivo: `server.py`**
```python
from flask import Flask, request, jsonify, render_template
from datetime import datetime
import threading

app = Flask(__name__)

# Banco de dados em memória (simples para demonstração)
data_store = {
    "groups": {},
    "last_updated": None
}
data_lock = threading.Lock()  # Para evitar conflitos de threads

# Configurações
PORT = 5000
DEBUG = True  # Modo de depuração (desativar em produção)
```

---

### **2. Rotas da API**

#### **Rota 1: Página Inicial (Instruções)**
```python
@app.route('/')
def index():
    return render_template('index.html')  # Página HTML com instruções
```

#### **Rota 2: Envio de Dados (POST)**
```python
@app.route('/api/data', methods=['POST'])
def receive_data():
    try:
        data = request.get_json()
        
        # Validação mínima
        if not data or 'group_id' not in data or 'sensor_type' not in data:
            return jsonify({"error": "Dados inválidos"}), 400
        
        group_id = data['group_id']
        
        with data_lock:
            data_store["groups"][group_id] = {
                "data": data,
                "timestamp": datetime.now().isoformat()
            }
            data_store["last_updated"] = datetime.now().isoformat()
        
        return jsonify({"status": "Dados recebidos!"}), 200
    
    except Exception as e:
        return jsonify({"error": str(e)}), 500
```

#### **Rota 3: Consulta de Dados (GET)**
```python
@app.route('/api/data/<group_id>', methods=['GET'])
def get_data(group_id):
    with data_lock:
        group_data = data_store["groups"].get(group_id)
        if not group_data:
            return jsonify({"error": "Grupo não encontrado"}), 404
        
        return jsonify(group_data), 200
```

#### **Rota 4: Dashboard (Visualização)**
```python
@app.route('/dashboard')
def dashboard():
    with data_lock:
        return render_template('dashboard.html', groups=data_store["groups"])
```

---

### **3. Templates HTML**

#### **Arquivo: `templates/index.html`**
```html
<!DOCTYPE html>
<html>
<head>
    <title>API de Sensores - Instruções</title>
</head>
<body>
    <h1>Bem-vindo à API de Sensores!</h1>
    <p>Envie dados do NodeMCU via POST para <code>/api/data</code> com o JSON:</p>
    <pre>
{
    "group_id": "grupo1",
    "sensor_type": "temperature",
    "value": 25.5
}
    </pre>
    <p>Visualize dados no <a href="/dashboard">Dashboard</a>.</p>
</body>
</html>
```

#### **Arquivo: `templates/dashboard.html`**
```html
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard de Sensores</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        tr:nth-child(even) { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Dados Recebidos</h1>
    <table>
        <tr>
            <th>Grupo</th>
            <th>Tipo de Sensor</th>
            <th>Valor</th>
            <th>Última Atualização</th>
        </tr>
        {% for group_id, data in groups.items() %}
        <tr>
            <td>{{ group_id }}</td>
            <td>{{ data.data.sensor_type }}</td>
            <td>{{ data.data.value }}</td>
            <td>{{ data.timestamp }}</td>
        </tr>
        {% endfor %}
    </table>
</body>
</html>
```

---

### **4. Código para o NodeMCU (MicroPython)**

#### **Arquivo: `nodemcu_http.py`**
```python
import network
import time
import urequests
import ujson

# Configurações
WIFI_SSID = "COLLEGE_NETWORK"
WIFI_PASSWORD = "COLLEGE_PASSWORD"
API_URL = "http://IP_DO_SERVIDOR:5000/api/data"  # Substituir pelo IP do servidor Flask

# Conectar ao Wi-Fi
wifi = network.WLAN(network.STA_IF)
wifi.active(True)
wifi.connect(WIFI_SSID, WIFI_PASSWORD)

while not wifi.isconnected():
    time.sleep(1)

print("Conectado ao Wi-Fi!")

# Dados do sensor (exemplo)
group_id = "grupo1"
sensor_type = "temperature"

while True:
    try:
        # Simular leitura do sensor
        sensor_value = 25.5  # Substituir pela leitura real
        
        # Criar payload JSON
        payload = {
            "group_id": group_id,
            "sensor_type": sensor_type,
            "value": sensor_value
        }
        
        # Enviar dados para o servidor
        response = urequests.post(
            API_URL,
            headers={"Content-Type": "application/json"},
            data=ujson.dumps(payload)
        )
        
        print("Resposta do servidor:", response.text)
        response.close()
    
    except Exception as e:
        print("Erro:", e)
    
    time.sleep(10)  # Enviar a cada 10 segundos
```

---

### **5. Execução do Servidor**

1. **Instale as dependências**:
   ```bash
   pip install flask
   ```

2. **Inicie o servidor Flask**:
   ```bash
   python server.py
   ```

3. **Acesse no navegador**:
   - Instruções: `http://localhost:5000`
   - Dashboard: `http://localhost:5000/dashboard`

---

### **6. Testando a API**

#### **Via Curl (para testes rápidos)**
```bash
curl -X POST -H "Content-Type: application/json" -d '{"group_id":"grupo2","sensor_type":"humidity","value":60}' http://localhost:5000/api/data
```

#### **Via Python (exemplo para alunos)**
```python
import requests

response = requests.post(
    "http://IP_DO_SERVIDOR:5000/api/data",
    json={
        "group_id": "grupo3",
        "sensor_type": "altitude",
        "value": 100.5
    }
)

print(response.json())
```

---

### **7. Melhorias Sugeridas**

1. **Autenticação Simples**:
   ```python
   # Adicione um token nos headers
   headers = {"Authorization": "Bearer SENHA_DO_GRUPO"}
   ```

2. **Persistência de Dados**:
   Use SQLite ou um arquivo JSON para salvar os dados permanentemente.

3. **Limite de Taxa**:
   Use `flask-limiter` para evitar spam de requisições.

4. **Documentação Swagger**:
   Integre com `flask-restx` para uma API auto-documentada.

---

### **8. Problemas Comuns**

1. **CORS (Cross-Origin Resource Sharing)**:
   Adicione o cabeçalho `Access-Control-Allow-Origin` se os alunos testarem de navegadores:
   ```python
   from flask_cors import CORS
   CORS(app)
   ```

2. **Erros de Conexão**:
   - Verifique se o servidor está acessível na rede do colégio.
   - Use `ping` e `telnet` para testar a conectividade.

3. **Formato JSON Incorreto**:
   Garanta que os alunos estejam enviando cabeçalhos `Content-Type: application/json`.

---

Com este sistema, os alunos poderão:
- Enviar dados de sensores via HTTP.
- Verificar se seus dados chegaram ao servidor.
- Comparar resultados com outros grupos no dashboard. 

Quer ajustar algo ou adicionar funcionalidades específicas? 😊