$mysqli = new mysqli("localhost", "username", "password", "database_name");\n\n// Get table structure\n$result = $mysqli->query("SHOW COLUMNS FROM table_name");\nwhile ($row = $result->fetch_assoc()) {\n    print_r($row);\n}\n\n// Get list of all tables\n$result = $mysqli->query("SHOW TABLES");\nwhile ($row = $result->fetch_assoc()) {\n    print_r($row);\n}\n\n$mysqli->close();