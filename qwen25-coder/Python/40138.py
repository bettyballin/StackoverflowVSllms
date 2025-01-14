import pyodbc\n\ndef execute_mdx_query(connection_string, mdx_query):\n    try:\n        # Establish a connection to the OLAP cube\n        conn = pyodbc.connect(connection_string)\n        cursor = conn.cursor()\n\n        # Execute the MDX query\n        cursor.execute(mdx_query)\n\n        # Fetch and return results\n        return cursor.fetchall()\n    \n    except Exception as e:\n        print(f"An error occurred: {e}")\n    finally:\n        if conn:\n            conn.close()\n\n# Example usage\nconnection_string = 'DRIVER={SQL Server};SERVER=your_server;DATABASE=your_database;'\nmdx_query = """\nSELECT \n    [Product].[Category].Members ON COLUMNS,\n    [Date].[Calendar Year].Members ON ROWS\nFROM \n    [Sales]\n"""\nresults = execute_mdx_query(connection_string, mdx_query)\nfor row in results:\n    print(row)