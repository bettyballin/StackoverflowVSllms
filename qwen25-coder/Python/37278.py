import pyodbc\nimport cx_Oracle\n\n# Connect to SQL Server\nsql_server_conn = pyodbc.connect('DRIVER={SQL Server};SERVER=(local);DATABASE=YourDatabase;Trusted_Connection=yes;')\nsql_server_cursor = sql_server_conn.cursor()\n\n# Execute query to fetch data\nsql_server_cursor.execute("SELECT * FROM YourTable")\nrows = sql_server_cursor.fetchall()\n\n# Connect to Oracle 10g XE\noracle_conn = cx_Oracle.connect('username/password@localhost:1521/XE')\noracle_cursor = oracle_conn.cursor()\n\n# Insert data into Oracle table\nfor row in rows:\n    oracle_cursor.execute("""\n        INSERT INTO YourOracleTable (Column1, Column2)\n        VALUES (:1, :2)""", (row.Column1, row.Column2))\n\n# Commit and close connections\noracle_conn.commit()\nsql_server_cursor.close()\nsql_server_conn.close()\noracle_cursor.close()\noracle_conn.close()