#!/usr/bin/python3
# -*- utf-8 -*-
"""
    Usage: pwd.py add username

"""

import sys
from pwdlibs import lerArquivo, checkUser, AddUser

if len(sys.argv) == 1:
    arquivo = "password.txt"
    dados = lerArquivo(arquivo)
    comando = input("Entre o comando desejado - add ou update: ")
    while not (comando == "add" or comando == "update"):
        comando = input("Comando inválido. Entre uma opção válida - add ou update: ")

    # --- Add user ---
    if comando == "add":
        """
            Verifica se o usuário existe, se exixtir, pede outro nome
            Se não existir, pede a senha 2x
        """
        # pede nome usuario
        usuario = input("Qual o nome de usuário a ser adicionado? ")
        # checa se o usuário já existe
        while checkUser(dados, usuario.lower()):
            usuario = input("Usuário já existe!\nFavor utilizar outro: ")
        if not checkUser(dados, usuario):
            AddUser(arquivo, usuario)

    # --- Update User ---
    elif comando == "update":
        # pede nome do usuário e valida se ele existe
        usuario = input("Nome de usuário: ")
        AddUser(arquivo, usuario)
