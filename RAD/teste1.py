#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Apr 29 20:00:00 2023

@author: vitor
"""

from pwdlibs import lerArquivo, checkUser, AddUser, UpdateUser, checkPass, hashSenha

dados = lerArquivo('password.txt')

checkPass(dados, 'daniel', '20')


#%%

matches = [x for x in dados if x[0] == 'daniel']

salt_salvo = matches[0][1][:32]
chave_salva = matches[0][1][32:]

salt, chave = hashSenha('20', salt_salvo)

#%%
if chave == chave_salva:
    True
else:
    print("Senha não confere")
    False

"""

passos:

    1. Coloca tudo em string (hex())
    2. Concatena
    3. Converte para byte
    4. Salva no arquivo

    Para ler:
        1. abre em byte
        2. convert para string (decode)
        3. manipula a string - strip, split
        4. converte o salt para byte
        5. gera a nova chave
        6. checa as duas chaves

"""  