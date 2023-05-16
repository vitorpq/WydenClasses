#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May 16 06:31:51 2023

@author: vitor
"""

import sqlite3 as conector

conexao = conector.connect('demo.sqlite')


# aquisição de um cursor
cursor = conexao.cursor()

cursor.execute("select * from Album")

dados = cursor.fetchall()

for album in dados:
    print(album)


#%%

sql = 'select AlbumId as "N. Album", Title as "Nome Album", Name as "Artista" \
    from Album, Artist where Album.ArtistId == Artist.ArtistId \
        and Name="Audioslave";'

cursor.execute(sql)

nova_query = cursor.fetchall()

print(nova_query)

#%%
conexao.close()