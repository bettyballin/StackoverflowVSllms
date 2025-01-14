import psycopg2\n\n# Establishing the connection\nconn = psycopg2.connect(\n    dbname="your_dbname", \n    user="your_username", \n    password="your_password", \n    host="127.0.0.1"\n)\ncur = conn.cursor()\n\n# Executing an SQL query\nquery = "SELECT * FROM users;"\ncur.execute(query)\n\n# Fetching all rows from the database table\nrows = cur.fetchall()\nprint(rows)\n\n# Closing the connection\ncur.close()\nconn.close()