#!/usr/bin/env python3


import hashlib

with open('senhas.txt') as f:
	
	conteudo = f.readlines()
	#print(conteudo)
	
	for linha in conteudo:
		senha = linha.strip('\n').split(':')[1]

hash_salvo = senha

#print(hash_salvo)

hash_senha = hash_salvo[64:]
print(hash_senha)


print('Tamanhho Total', len(hash_salvo))
print('Tamanhho Sal', len(hash_salvo[:64]))
print('Tamanhho Senha', len(hash_salvo[64:]))

print("Sal: ", hash_salvo[:64])
print('Senha: ', hash_salvo[64:])

hash_sal = hash_salvo[:64].encode('utf-8')

entrada_senha = input("Entre a senha: ")


chave = hashlib.pbkdf2_hmac('sha256', entrada_senha.encode('utf-8'), \
		hash_sal, 100000)

chave_hex = chave.hex()

if chave_hex == hash_senha:
	print("ok")
	
else:
	print("Senha errada")




