import sqlite3\n\n   conn = sqlite3.connect(':memory:')\n   cursor = conn.cursor()\n   cursor.execute('CREATE TABLE users (id integer primary key, name text)')\n   cursor.execute('INSERT INTO users (name) VALUES (?)', ('Alice',))\n   conn.commit()