$dsn = "DRIVER={FreeTDS};SERVER=my_server;DATABASE=my_database;UID=my_username;PWD=my_password";\n$conn = odbc_connect($dsn);\nif (!$conn) {\n    echo "Connection failed";\n} else {\n    echo "Connected";\n}