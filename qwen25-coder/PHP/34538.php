$mysqli = new mysqli("host", "username", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$query = "SELECT val FROM table WHERE id = 1";\n$result = $mysqli->query($query);\n\nif ($result && $result->num_rows > 0) {\n    $row = $result->fetch_row(); // Fetch the row as an indexed array\n    $value = $row[0]; // Get the first column's value\n} else {\n    $value = null; // Handle no result case\n}\n\n$result->close();\n$mysqli->close();