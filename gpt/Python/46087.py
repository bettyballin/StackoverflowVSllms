import cx_Oracle\n\n   connection = cx_Oracle.connect("user/password@dsn")\n   cursor = connection.cursor()\n   cursor.execute("SELECT * FROM your_table")\n\n   row = cursor.fetchone()\n   while row is not None:\n       print(row)\n       row = cursor.fetchone()\n\n   cursor.close()\n   connection.close()