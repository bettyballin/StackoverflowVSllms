$mysqli = new mysqli('localhost', 'your_username', 'your_password', 'your_database');\n$result = $mysqli->query('SELECT * FROM your_table');\nwhile ($row = $result->fetch_assoc()) {\n    // Process the row\n}