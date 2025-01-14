<?php\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\n// Check connection\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("INSERT INTO users (username, email) VALUES (?, ?)");\n$stmt->bind_param("ss", $username, $email);\n\n$username = "exampleUser";\n$email = "user@example.com";\n\n$stmt->execute();\n\necho "New records created successfully";\n\n$stmt->close();\n$mysqli->close();\n?>