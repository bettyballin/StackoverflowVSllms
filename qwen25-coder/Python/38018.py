# Example of using SQLite in Python for handling music metadata\n     import sqlite3\n\n     connection = sqlite3.connect('music_collection.db')\n     cursor = connection.cursor()\n\n     # Create table\n     cursor.execute('''CREATE TABLE IF NOT EXISTS songs (\n         id INTEGER PRIMARY KEY,\n         filename TEXT,\n         format TEXT,\n         size INTEGER,\n         artist TEXT,\n         title TEXT,\n         album TEXT,\n         genre TEXT,\n         length REAL,\n         year_of_release INTEGER,\n         directory TEXT,\n         status TEXT)''')\n\n     # Insert data\n     cursor.execute('''INSERT INTO songs (filename, format, size, artist, title) VALUES (?, ?, ?, ?, ?)''',\n                    ('song.mp3', 'mp3', 5242880, 'Artist Name', 'Song Title'))\n     connection.commit()\n     connection.close()