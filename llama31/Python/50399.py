import cx_Oracle\n\nconn = cx_Oracle.connect("username/password@dsn")\ncursor = conn.cursor()\n\ncursor.execute("SELECT * FROM mytable")\n\nwhile True:\n    row = cursor.fetchone()\n    if row is None:\n        break\n    print(row)\n\nconn.close()