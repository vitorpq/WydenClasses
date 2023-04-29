#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Apr 14 07:39:40 2023

@author: vitor
"""

try:
    f = open('password.txt')
except FileNotFoundError as NomeErro:
    print(NomeErro)
else:
    
finally:
#     # Ele é um código que será executado mesmo que o erro
#     # não seja levantado
    print(f.read())
    f.close()

#%%

x = -1
vetor = []

print(vetor[x])

#%%
try:
    if x < 0:
        raise Exception("Indice não pode ser menor que zero, favor usar números de 0 a 10")
    print(vetor[x])
except Exception as Erro:
    print(Erro)

#%%
x = -1
if x < 0:
    raise Exception("Indice não pode ser menor que zero")

print(vetor[x])