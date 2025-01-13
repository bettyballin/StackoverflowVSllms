import sqlite3\n\n# Create an in-memory SQLite database\nconnection = sqlite3.connect(':memory:')\ncursor = connection.cursor()\n\n# Create a table\ncursor.execute('CREATE TABLE example (id INTEGER PRIMARY KEY, value TEXT)')\n\n# Insert some data\ncursor.execute('INSERT INTO example (value) VALUES (?)', ('test value',))\n\n# Query the data\ncursor.execute('SELECT * FROM example')\nprint(cursor.fetchall())\n\n# Close the connection\nconnection.close()