$stmt = $mysqli->prepare("SELECT * FROM users WHERE username = ?");\n$stmt->bind_param("s", $username);\n$stmt->execute();