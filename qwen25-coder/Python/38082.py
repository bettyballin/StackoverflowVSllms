cursor.execute("SELECT * FROM your_table")\n     rows = cursor.fetchmany(10)  # Adjust the size as needed\n     while rows:\n         for row in rows:\n             print(row)\n         rows = cursor.fetchmany(10)