cursor.execute("SELECT * FROM your_table")\n     row = cursor.fetchone()\n     while row:\n         print(row)\n         row = cursor.fetchone()