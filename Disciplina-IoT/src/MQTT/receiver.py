import paho.mqtt.client as paho
from paho import mqtt
import base64
import time
import os
import sys

# --- Configurações OBRIGATÓRIAS ---
mqtt_broker_address = "28a6f2cda33d4edd968db56415df18b6.s1.eu.hivemq.cloud" # <<-- SEU ENDEREÇO AQUI
mqtt_port = 8883  # Porta TLS padrão do HiveMQ Cloud
mqtt_username = "vitorpq"
mqtt_password = "vitorpq01A"
mqtt_topic_to_subscribe = "#" # <<-- Tópico para escutar (use '#' como wildcard)
# IMPORTANTE: Client ID Fixo para Sessão Persistente!
mqtt_client_id_receptor = "meu-receptor-trabalhos-01"
output_directory = "arquivos_recebidos" # Pasta para salvar os arquivos
# --- Fim das Configurações ---
