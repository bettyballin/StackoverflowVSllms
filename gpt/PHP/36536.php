$conn = mysql_connect("localhost", "user", "password");\nmysql_select_db("database", $conn);\n\n$username = mysql_real_escape_string($username, $conn);\n$password = mysql_real_escape_string($password, $conn);\n\n$query = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";\n$result = mysql_query($query, $conn);\n\nwhile ($row = mysql_fetch_assoc($result)) {\n    // Process the result\n}\n\nmysql_free_result($result);\nmysql_close($conn);