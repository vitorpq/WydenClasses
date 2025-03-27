from flask import Flask, request, jsonify, render_template
from datetime import datetime
import threading
import json
import os

app = Flask(__name__)

# Configurações
DATA_FILE = "sensor_data.json"
PORT = 3000
DEBUG = True

# Lock para operações thread-safe
data_lock = threading.Lock()

def load_data_from_file():
    """Carrega dados do arquivo JSON"""
    try:
        if os.path.exists(DATA_FILE):
            with open(DATA_FILE, 'r') as f:
                return json.load(f)
        return {"groups": {}, "last_updated": None}
    except Exception as e:
        print(f"Erro ao carregar dados: {e}")
        return {"groups": {}, "last_updated": None}

def save_data_to_file(data):
    """Salva dados no arquivo JSON"""
    try:
        with open(DATA_FILE, 'w') as f:
            json.dump(data, f, indent=2)
    except Exception as e:
        print(f"Erro ao salvar dados: {e}")

# Carregar dados iniciais
data_store = load_data_from_file()

@app.route('/')
def index():
    return render_template('index.html')  # Página HTML com instruções

@app.route('/api/data', methods=['POST'])
def receive_data():
    try:
        data = request.get_json()
        
        if not data or 'group_id' not in data or 'sensor_type' not in data:
            return jsonify({"error": "Dados inválidos"}), 400
        
        group_id = data['group_id']
        timestamp = datetime.now().isoformat()
        
        with data_lock:
            # Atualizar dados na memória
            data_store["groups"][group_id] = {
                "data": data,
                "timestamp": timestamp
            }
            data_store["last_updated"] = timestamp
            
            # Persistir no arquivo
            save_data_to_file(data_store)
        
        return jsonify({"status": "Dados recebidos!"}), 200
    
    except Exception as e:
        return jsonify({"error": str(e)}), 500

@app.route('/api/data/<group_id>', methods=['GET'])
def get_data(group_id):
    with data_lock:
        group_data = data_store["groups"].get(group_id)
        if not group_data:
            return jsonify({"error": "Grupo não encontrado"}), 404
        
        return jsonify(group_data), 200

@app.route('/dashboard')
def dashboard():
    with data_lock:
        return render_template('dashboard.html', 
                           groups=data_store["groups"],
                           last_updated=data_store["last_updated"])

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=PORT, debug=DEBUG)