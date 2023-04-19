#!/usr/bin/python3
# -*- utf-8 -*-

""" Manipulação de Strings 
	pwd.py update norberto
	
	1. Verificar o comando passado ao programa
	2. Ler o arquivo se o comando for update
	3. Ler as linhas do arquivo
	4. Verificar se o usuário passado na linha comando existe
	5. Se existir: pedir a senha atual
	6. Pedir a nova senha
"""
userName = "vitor"

userPass = "656564654"

try:
	f = open("password.txt")
except Exception as Erro:
	print("Arquivo não existente")
	print("Descrição do erro", Erro)

# Lista temporária com as senhas
novoConteudo = []

for linha in f.readlines():
	
	nome = linha.strip("\n").split(":")[0]
	senha = linha.strip("\n").split(":")[1]
	# Encontro o nome do usuário fornecido
	if userName == nome:
		print(nome)
		# Verifico se a senha que ele forneceu é igual a salva
		if userPass == senha:
			print("Senha correta: ", senha)
			# Pedir a nova senha do usuário
			novaSenha = "hh888Ut"
			# Salvar a nova do usuário na lista de senhas
			novoConteudo.append(nome+":"+novaSenha+"\n")
			
			# print(novoConteudo)
	else:
		novoConteudo.append(linha)

print(novoConteudo)

try:
	f = open("password.txt", "w")
except Exception as Erro:
	print("Arquivo não existente")
	print("Descrição do erro", Erro)
else:
	f.writelines(novoConteudo)
			
			

	
	

