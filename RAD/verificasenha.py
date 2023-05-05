#!/usr/bin/env python3


import hashlib

with open('senhas.txt') as f:
	
	conteudo = f.readlines()
	#print(conteudo)
	
	for linha in conteudo:
		sal_e_chave = linha.strip('\n').split(':')[1]

chave = sal_e_chave[64:]

sal = sal_e_chave[:64]

entrada_senha = b'20'

checkChave = hashlib.pbkdf2_hmac('sha256', entrada_senha, \
		sal.encode('utf-8'), 100000)

if checkChave.hex() == chave:
	print("ok")
	
else:
	print("Senha errada")




