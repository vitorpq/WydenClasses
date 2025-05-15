# 2. Preparar Payload JSON
metadata_payload = {
    "group_id": group_id,
    "original_filename": original_filename,
    "file_hash_sha256": file_hash_sha256,
    "download_link": file_download_link,
    "submission_timestamp_utc": utime.gmtime() # Timestamp UTC (formato pode variar)
    # Considerar formatar o timestamp como ISO 8601 se possível/necessário
}

# Converte para string JSON
try:
    json_payload_str = ujson.dumps(metadata_payload)
    # Codifica para bytes (necessário para umqtt.simple.publish)
    json_payload_bytes = json_payload_str.encode('utf-8')
    print("Payload JSON preparado (bytes):", json_payload_bytes[:100], "...") # Mostra início
except Exception as e:
    print(f"Erro ao criar JSON: {e}")
    usys.exit()