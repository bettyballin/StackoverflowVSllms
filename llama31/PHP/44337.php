$host = "mssqlhost";\n$user = "phpbb2";\n$password = "phpbb2";\n\n$connect_sql_server = mssql_connect($host, $user, $password);\n\nif (!$connect_sql_server) {\n    die('Connect Error (' . mssql_get_last_message() . ')');\n}