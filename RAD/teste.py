#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Apr 29 15:54:12 2023

@author: vitor
"""

import hashlib
import os
import codecs

#%%

# criar as strings

usuario = 'vitor'
sal = os.urandom(16)


chave = hashlib.pbkdf2_hmac('sha256', senha, sal, 100000)

string = usuario+":"+sal.hex()+chave.hex()+'\n'

f = open('senhas.txt', 'wb')
f.write(string.encode('utf-8'))
f.close()

print(string)
#%%

f = open('senhas.txt', 'rb')
conteudo = f.readlines()
print(conteudo)



#%%

string_nova = conteudo[0].decode('utf-8')

senhaSalva = string_nova.strip('\n').split(':')[1]

salt = senhaSalva[:32]

salt = bytes.fromhex(salt)

chaveCheck = chave = hashlib.pbkdf2_hmac('sha256', senha, salt, 100000)

#%%
if chaveCheck.hex() == senhaSalva[32:]:
    print('ok')
#%%

senha = b'20'

sal = os.urandom(32)

chave = hashlib.pbkdf2_hmac('sha256', senha, sal, 100000, dklen=128)

storage = sal.hex() + chave.hex()
#%% retorno

senhacheck = b'20'

chavenova = hashlib.pbkdf2_hmac('sha256', senhacheck, sal, 100000, dklen=128)

#%%
if chavenova.hex() == storage[64:]:
    print('ok')
    
