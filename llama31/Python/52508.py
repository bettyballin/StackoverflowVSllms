import psycopg2\n\n# Connect to the test database\nconn = psycopg2.connect(\n    host="your_host",\n    database="your_database",\n    user="your_user",\n    password="your_password"\n)\n\n# Retrieve the affected tables from the audit logs\ncur = conn.cursor()\ncur.execute("SELECT query, calls, rows_affected FROM pg_stat_statements WHERE query LIKE 'DELETE%';")\naffected_tables = [row[0].split()[2] for row in cur.fetchall()]\n\n# Compare the affected tables with the expected list\nexpected_tables = ["table1", "table2", "table3"]  # Replace with your expected list\nif set(affected_tables) != set(expected_tables):\n    print("Warning: Unexpected tables affected!")\nelse:\n    print("Only expected tables affected.")\n\n# Close the database connection\nconn.close()