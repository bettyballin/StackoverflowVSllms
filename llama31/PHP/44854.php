mysql_connect("localhost", "username", "password");\nmysql_select_db("database");\n\n$query = "SELECT * FROM users WHERE email = '".mysql_real_escape_string($email)."'";\n$result = mysql_query($query);\n\n// Fetch the result\nwhile ($row = mysql_fetch_assoc($result)) {\n    // Process the row\n}