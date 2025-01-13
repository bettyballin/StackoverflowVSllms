$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("INSERT INTO users (username, email) VALUES (?, ?)");\n$stmt->bind_param("ss", $username, $email);\n\n$username = "exampleuser";\n$email = "user@example.com";\n\n$stmt->execute();\n$stmt->close();\n$mysqli->close();