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
    app.run(host='0.0.0.0', port=3000, debug=True)