import base64\nimport pyodbc  # Example library for ODBC connection\n\n# Encoded password\nencoded_password = "eW91cl9wYXNzd29yZA=="\n\n# Decode the password\ndecoded_password = base64.b64decode(encoded_password).decode("utf-8")\n\n# Create the connection string\nconnection_string = f"DRIVER={{...}};SERVER=...;UID=your_username;PWD={decoded_password};"\n\n# Establish the connection\nconnection = pyodbc.connect(connection_string)\n\n# Your code to use the connectio