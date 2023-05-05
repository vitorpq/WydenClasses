#!/usr/bin/env python3


import hashlib
import os


# Para salvar usar o sal, devemos transformar ele em uma string Hexadecinmal
# depois converter para byte
# 
sal = os.urandom(32).hex().encode('utf-8')

senha = b'20'

chave = hashlib.pbkdf2_hmac('sha256', senha, sal, 100000)

usuario = 'daniel'

with open('senhas.txt', 'w') as f:
	f.write(usuario+':'+sal.decode('utf-8')+chave.hex()+'\n')








