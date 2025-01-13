import sqlite3\n\n# Open the database in WAL mode\nconn = sqlite3.connect('example.db', isolation_level='IMMEDIATE')\ncursor = conn.cursor()\n\n# Create a table\ncursor.execute('CREATE TABLE IF NOT EXISTS my_table (id INTEGER PRIMARY KEY, name TEXT NOT NULL)')\n\n# Insert some data\ncursor.execute('INSERT INTO my_table (name) VALUES (?)', ('John Doe',))\n\n# Commit the transaction\nconn.commit()\n\n# Close the connection\nconn.close()