// Using mysqli_fetch_assoc()\n$mysqli = new mysqli("hostname", "username", "password", "database");\n$result = $mysqli->query("SELECT * FROM table");\nwhile ($row = $result->fetch_assoc()) {\n    echo $row['column_name'];\n}\n\n// Using mysqli_fetch_object()\n$mysqli = new mysqli("hostname", "username", "password", "database");\n$result = $mysqli->query("SELECT * FROM table");\nwhile ($row = $result->fetch_object()) {\n    echo $row->column_name;\n}