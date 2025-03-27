from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/dados', methods=['POST'])
def receber_dados():
    dados = request.json
    print("Dados recebidos:", dados)
    return jsonify({"status": "sucesso", "dados": dados}), 200

if __name__ == '__main__':
    # Executa o servidor Flask em todos os endereços IP da rede local
    app.run(debug=True, port=3000, host='0.0.0.0')