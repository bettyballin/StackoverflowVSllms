import sqlite3\n\n# Create a table with an "int" column\nconn = sqlite3.connect(':memory:')\ncursor = conn.cursor()\ncursor.execute('CREATE TABLE example (id int)')\n\n# Insert a string value into the "int" column\ncursor.execute('INSERT INTO example (id) VALUES (?)', ('hello',))\n\n# Retrieve the value\ncursor.execute('SELECT id FROM example')\nresult = cursor.fetchone()\nprint(result[0])  # Output: hello\n\nconn.close()