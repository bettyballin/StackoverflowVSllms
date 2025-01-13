import pyodbc\n\n# Define the connection string\nconstr = (\n    r'DRIVER={ODBC Driver 17 for SQL Server};'\n    r'SERVER=servername;'\n    r'DATABASE=dbname;'\n    r'Trusted_Connection=yes;'\n)\n\n# Establish the connection\ntry:\n    connection = pyodbc.connect(constr)\n    print("Connection successful!")\nexcept Exception as e:\n    print(f"Connection failed: {e}")