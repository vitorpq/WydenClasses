#!/usr/bin/python3
# -*- utf-8 -*-
import os
import hashlib


def lerArquivo(arquivo):
    with open(arquivo, "rb") as f:
        dados = []
        for linha in f.readlines():
            linha = linha.decode('utf-8')
            nome = linha.strip("\n").split(":")[0]
            senha = linha.strip("\n").split(":")[1]
            dados.append([nome, senha])
    return dados

# %% checkUser
# Usuário existe?


def checkUser(dados, usuario):

    matches = [x for x in dados if x[0] == usuario]

    if not matches:
        return False
    else:
        return True


# %% checkPass

def checkPass(dados, usuario, senha):

    matches = [x for x in dados if x[0] == usuario]

    salt_salvo = matches[0][1][:32]
    chave_salva = matches[0][1][32:]

    salt, chave = hashSenha(senha, salt_salvo)

    if chave == chave_salva:
        return True
    else:
        print("Senha não confere")
        return False


#%% Add user
def AddUser(arquivo, usuario):
    try:
        with open(arquivo, "a") as f:
            senha_1 = input("Entre com a nova senha: ")
            senha_2 = input("Repita a mesma senha: ")
            while senha_2 != senha_1:
                senha_2 = input("Senha não confere.\nRepita a mesma senha: ")
            
            salt, chave = hashSenha(senha_1)
            storage = salt.hex() + chave.hex()
            f.write(f'{usuario}:{storage}\n')
    except Exception as erro:
        print(erro)


def UpdateUser(dados, usuario):
    if checkUser(dados, usuario):
        senha = input("Sua senha atual: ")
        if checkPass(dados, usuario, senha):
            novaSenha_1 = input("Nova senha: ")
            novaSenha_2 = input("Repita a mesma senha: ")
            while novaSenha_1 != novaSenha_2:
                novaSenha_2 = input("Senha não confere.\nRepita a mesma senha: ")

        # salva a senha no arquivo
            index = [idx for idx, linha in enumerate(dados) if linha[0] == usuario][0]

            dados[index][1] = novaSenha_1

            with open("password.txt", "w") as f:
                for linha in dados:
                    f.write(f"{linha[0]}:{linha[1]}\n")
                print("Senha atualizada com sucesso!")
    else:
        print("usuário não existe")


#%% Password Hashing
def hashSenha(senha, *args):

    if args:
        salt = args[0]
        chave = hashlib.pbkdf2_hmac('sha256', senha.encode('UTF-8'), salt, 100_000)
    else:
        salt = os.urandom(32)
        chave = hashlib.pbkdf2_hmac('sha256', senha.encode('UTF-8'), salt, 100_000)

    return salt, chave
