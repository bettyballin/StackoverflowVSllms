import mysql.connector\nfrom difflib import ndiff\n\ndef get_database_schema(cursor, database):\n    cursor.execute(f"SHOW CREATE DATABASE `{database}`")\n    return cursor.fetchone()[1]\n\ndef get_table_schema(cursor, table):\n    cursor.execute(f'SHOW CREATE TABLE `{table}`')\n    return cursor.fetchone()[1]\n\ndef diff_databases(conn_params1, conn_params2, db1_name, db2_name):\n    conn1 = mysql.connector.connect(**conn_params1)\n    conn2 = mysql.connector.connect(**conn_params2)\n    \n    cursor1 = conn1.cursor()\n    cursor2 = conn2.cursor()\n\n    # Fetch list of tables\n    cursor1.execute(f"SHOW TABLES IN `{db1_name}`")\n    db1_tables = [table[0] for table in cursor1.fetchall()]\n    \n    cursor2.execute(f"SHOW TABLES IN `{db2_name}`")\n    db2_tables = [table[0] for table in cursor2.fetchall()]\n\n    # Compare tables present in both databases\n    for table in set(db1_tables) & set(db2_tables):\n        schema_db1 = get_table_schema(cursor1, table)\n        schema_db2 = get_table_schema(cursor2, table)\n\n        diff = list(ndiff(schema_db1.splitlines(), schema_db2.splitlines()))\n        changes = [d[2:] for d in diff if d.startswith('- ') or d.startswith('+ ')]\n        \n        # Print changes here, or generate sql statements as needed\n        print(f"Changes detected in table {table}:")\n        print('\n'.join(changes))\n\n    # Close connections\n    conn1.close()\n    conn2.close()\n\n# Example usage, adjust connection parameters\nconn_params_db1 = {\n    'user': 'your_user',\n    'password': 'your_password',\n    'host': 'host_for_database1',\n    'database': 'db1'\n}\n\nconn_params_db2 = {\n    'user': 'your_user',\n    'password': 'your_password',\n    'host': 'host_for_database2',\n    'database': 'db2'\n}\n\ndiff_databases(conn_params_db1, conn_params_db2, 'database1', 'database2')