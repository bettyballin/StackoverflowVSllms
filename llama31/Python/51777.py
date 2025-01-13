import sqlite3\n\n# Connect to the database\nconn = sqlite3.connect('example.db')\n\n# Create a cursor\ncursor = conn.cursor()\n\n# Create a table\ncursor.execute('''\n    CREATE TABLE users (\n        id INTEGER PRIMARY KEY,\n        name TEXT NOT NULL,\n        email TEXT UNIQUE NOT NULL\n    );\n''')\n\n# Insert a row\ncursor.execute("INSERT INTO users (name, email) VALUES ('John Doe', 'john@example.com');")\n\n# Commit the transaction\nconn.commit()\n\n# Close the connection\nconn.close()