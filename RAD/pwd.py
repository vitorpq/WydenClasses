#!/usr/bin/python3
# -*- utf-8 -*-
"""
	Usage: pwd.py add username
	
"""

import sys

from pwdlibs import AddUser, UpdateUser


if len(sys.argv) == 1:
	
	comando = input("Entre o comando desejado - add ou update: ")
	
	while comando != ("add" or "update"):
		comando = input("Comando inválido. Entre uma opção válida - add ou update: ")

	if comando == "add":
		
		AddUser()
		
	elif comando == "update":
		UpdateUser()
		
