📌 Roteiro de Aulas para a Disciplina ARA0058 - Aplicações de Cloud, IoT e Indústria 4.0 em Python

# 📅 Estrutura das Aulas

| Semana | Tema                                    | Atividade Principal                                               | Tecnologias Utilizadas              |
|--------|-----------------------------------------|-------------------------------------------------------------------|-------------------------------------|
| 1.     | Introdução à IoT                        | Conceitos, aplicações e configuração inicial do NodeMCU           | NodeMCU, MicroPython                |
| 2.     | Protocolos de Comunicação (HTTP e MQTT) | Envio de dados simulados via HTTP (Flask) e MQTT (Mosquitto)      | Flask (Google Colab), MQTT (HiveMQ) |
| 3.     | Leitura de Dados do Sensor     | Captura de temperatura, umidade e pressão e envio para o servidor | HTTP/MQTT                   |
| 4.     | Armazenamento e Visualização de Dados   | Salvar dados no Google Sheets e visualizar com Grafana            | Google Sheets API, Grafana          |
| 5.     | Automação e Tomada de Decisão           | Criar alertas automáticos baseados em valores do sensor           | Telegram Bot API, Webhooks          |
| 6.     | Integração com Nuvem                    | Envio de dados para Firebase ou ThingsBoard                       | Firebase, ThingsBoard               |
| 7.     | Segurança e Autenticação                | Proteção de dados usando autenticação no MQTT e HTTP              | TLS, JSON Web Tokens (JWT)          |
| 8.     | Projeto Final - Parte 1                 | Definição do projeto final pelos alunos                           | NodeMCU, API, Cloud                 |
| 9.     | Projeto Final - Parte 2                 | Apresentação dos projetos e conclusão                             | NodeMCU, API, Cloud                 |


# 📚 Detalhamento das Aulas
## 📌 Aula 1 - Introdução à IoT

📌 Conceitos básicos:
- O que é Internet das Coisas (IoT)?
- Exemplos práticos de IoT na Indústria 4.0.
- Como o NodeMCU se comunica com a nuvem.
- Configuração do MicroPython no NodeMCU.

📌 Atividade Prática:
✅ Instalar MicroPython no NodeMCU usando esptool.py.
✅ Rodar um script básico (main.py) para testar a comunicação serial.

⸻

📌 Aula 2 - Protocolos de Comunicação (HTTP e MQTT)

📌 Conceitos:
- Diferença entre HTTP e MQTT.
- Como os dados são enviados para a nuvem.

📌 Atividade Prática:
✅ Criar um servidor Flask no Google Colab para receber dados via HTTP.
✅ Enviar dados simulados via HTTP POST.
✅ Configurar um broker MQTT público (broker.hivemq.com).
✅ Publicar mensagens no tópico MQTT iot/nodemcu.

⸻

📌 Aula 3 - Leitura de Dados do Sensor (BME280)

📌 Conceitos:
- Como os sensores funcionam na IoT.
- Como conectar o BME280 ao NodeMCU.

📌 Atividade Prática:
✅ Ler temperatura, umidade e pressão do sensor.
✅ Enviar esses dados via HTTP para Flask no Google Colab.
✅ Publicar os dados via MQTT para Mosquitto.

⸻

📌 Aula 4 - Armazenamento e Visualização de Dados

📌 Conceitos:
- Como armazenar dados da IoT sem custo.
- Como usar Google Sheets como banco de dados.
- Introdução ao Grafana para visualização.

📌 Atividade Prática:
✅ Enviar dados do NodeMCU para Google Sheets via API.
✅ Criar gráficos no Grafana para visualizar os dados.

⸻

📌 Aula 5 - Automação e Tomada de Decisão

📌 Conceitos:
- Como usar Webhooks para automação.
- Criando um bot do Telegram para alertas IoT.

📌 Atividade Prática:
✅ Criar alertas no Telegram quando a temperatura estiver muito alta.
✅ Criar um webhook para notificação automática.

⸻

📌 Aula 6 - Integração com Serviços de Nuvem

📌 Conceitos:
- Como usar Firebase ou ThingsBoard.
- Por que integrar dispositivos com IoT na nuvem.

📌 Atividade Prática:
✅ Enviar dados do NodeMCU para Firebase via REST API.
✅ Criar um dashboard no ThingsBoard para monitoramento.

⸻

📌 Aula 7 - Segurança e Autenticação

📌 Conceitos:
- Por que segurança é essencial na IoT.
- Como proteger dados com TLS e autenticação.

📌 Atividade Prática:
✅ Adicionar autenticação via JSON Web Tokens (JWT) no Flask.
✅ Configurar TLS no MQTT usando Mosquitto.

⸻

📌 Aula 8 - Projeto Final (Parte 1)

📌 Atividade Prática:
✅ Cada grupo define seu projeto final.
✅ Definição do problema, objetivos e ferramentas.

⸻

📌 Aula 9 - Projeto Final (Parte 2)

📌 Apresentação dos projetos e encerramento.
✅ Cada grupo apresenta sua solução e demonstra o funcionamento.
✅ Discussão sobre aplicações reais e desafios.

⸻

📌 Conclusão

Com esse roteiro, os alunos aprenderão a conectar o NodeMCU à nuvem, enviar dados via HTTP e MQTT, armazenar e visualizar informações, automatizar processos e proteger dados IoT, tudo isso utilizando somente serviços gratuitos.

🚀 Se precisar de ajustes ou mais detalhes sobre uma aula específica, me avise! 🚀