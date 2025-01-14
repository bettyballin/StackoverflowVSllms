$stmt = $mysqli->prepare('SELECT * FROM users WHERE email = ?');\n   $stmt->bind_param('s', $email);\n   $stmt->execute();\n   $result = $stmt->get_result();\n   $user = $result->fetch_assoc();