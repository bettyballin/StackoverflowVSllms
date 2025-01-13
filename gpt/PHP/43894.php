<?php\n$mysqli = new mysqli("localhost", "user", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n$stmt = $mysqli->prepare("SELECT * FROM users WHERE username = ? AND password = ?");\nif ($stmt === false) {\n    die("Prepare failed: " . $mysqli->error);\n}\n\n$username = $_POST['username'];\n$password = $_POST['password'];\n\n$stmt->bind_param('ss', $username, $password);\n\n$stmt->execute();\n$result = $stmt->get_result();\n\nwhile ($row = $result->fetch_assoc()) {\n    echo "User: " . $row['username'];\n}\n\n$stmt->close();\n$mysqli->close();\n?>