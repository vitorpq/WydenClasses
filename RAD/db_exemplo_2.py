#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May 16 07:00:34 2023

@author: vitor
"""

import sqlite3

# Conectar ao banco de dados (ou criar um novo se não existir)
conn = sqlite3.connect('exemplo.db')

# Criar um cursor para executar comandos SQL
cursor = conn.cursor()

# Criar uma tabela
cursor.execute('''
    CREATE TABLE IF NOT EXISTS usuarios (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        nome TEXT,
        idade INTEGER
    )
''')

# Inserir dados na tabela
cursor.execute('INSERT INTO usuarios (nome, idade) VALUES (?, ?)', ('João', 25))
cursor.execute('INSERT INTO usuarios (nome, idade) VALUES (?, ?)', ('Maria', 30))

# Salvar as alterações no banco de dados
conn.commit()

# Fechar a conexão com o banco de dados
conn.close()
