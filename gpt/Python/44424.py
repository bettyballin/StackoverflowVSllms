import sqlite3\n\n   conn = sqlite3.connect('test.db')\n   cursor = conn.cursor()\n   cursor.execute("SELECT * FROM users WHERE email LIKE '%@example.com'")\n   rows = cursor.fetchall()\n   for row in rows:\n       print(row)\n   conn.close()