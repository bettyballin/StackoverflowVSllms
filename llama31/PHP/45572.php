$mysqli = new mysqli("your_host", "your_user", "your_password", "your_database");\n$query = "SELECT * FROM (...)"; // the query above\n$result = $mysqli->query($query);\nwhile ($row = $result->fetch_assoc()) {\n    // process the row\n}