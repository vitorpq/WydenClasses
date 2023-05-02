#!/usr/bin/env python3


import hashlib
import os


sal = os.urandom(32)

senha = b'25'

chave = hashlib.pbkdf2_hmac('sha256', senha, sal, 100000)

chave_salva = chave.hex()

sal_salvo = sal.hex()

print("Sal: ", sal_salvo)
print('Senha: ', chave_salva)

usuario = 'vitor'

with open('senhas.txt', 'w') as f:
	f.write(usuario+':'+sal_salvo+chave_salva+'\n')








