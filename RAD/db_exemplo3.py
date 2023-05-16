#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May 16 08:30:49 2023

@author: vitor
"""

import sqlite3

try:
    conn = sqlite3.connect('exemplo3.db')
    # conn = sqlite3.connect('exemplo3.db?mode=ro') - somente leitura
    # conn = sqlite3.connect('exemplo3.db?mode=rw') - modo escrita e leitutra

    cursor = conn.cursor()

    comando_pessoa = '''CREATE TABLE IF NOT EXISTS Pessoa (
                        cpf INTEGER NOT NULL,
                        nome TEXT NOT NULL,
                        nascimento DATE NOT NULL,
                        oculos BOOLEAN NOT NULL,
                        PRIMARY KEY (cpf)
                        );
                    '''
    comando_marca = '''CREATE TABLE IF NOT EXISTS Marca (
                       id INTEGER NOT NULL,
                       nome TEXT NOT NULL,
                       sigla CHAR(2) NOT NULL,
                       PRIMARY KEY (id)
                       );'''
    comando_veiculo = '''CREATE TABLE IF NOT EXISTS Veiculo (
                        placa CHAR(7) NOT NULL,
                        ano INTEGER NOT NULL,
                        cor TEXT NOT NULL,
                        proprietario INTEGER NOT NULL,
                        marca INTEGER NOT NULL,
                        PRIMARY KEY (placa),
                        FOREIGN KEY(proprietario) REFERENCES Pessoa(cpf),
                        FOREIGN KEY(marca) REFERENCES Marca(id)
                        );'''

    cursor.execute(comando_pessoa)
    cursor.execute(comando_marca)
    cursor.execute(comando_veiculo)

    conn.commit()

except sqlite3.DatabaseError as erro:
    print('Erro de banco de dados ', erro)

finally:
    if conn:
        conn.close()
