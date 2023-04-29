#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 14 08:24:00 2023

@author: vitor
"""

"""
 - Criar um arquivo em branco "teste.txt" - open
 - Criar um pasta chamada "novo" - os.mkdir
 - Mudar o arquivo de diretório -> "novo" - os.replace
"""

import os


#%% Criação do arquivo

try:
    # Cria o arquivo e o fecha
    open("teste.txt", "a").close()
    
except OSError as Erro:
    print("Erro ao criar arquivo")
    print("Descrição: ", Erro)
else:
    print("Arquivo criado")

#%%

try:
    os.mkdir("novo/teste")

except FileExistsError as Erro:
    print("Diretório já existe ->", Erro)

except PermissionError as Erro:
    print("Sem privilégio de administrador para criar o arquivo")
    print(Erro)
else:
    print("Pasta criado com sucesso!")

#%%
try:
    os.replace("teste.txt", "novo/teste.txt")
except FileNotFoundError as Erro:
    print("Pasta Novo não existe", Erro)
else:
    print("Arquivo movido com sucesso")
