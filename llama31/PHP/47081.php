// Use prepared statements to prevent SQL injection\n$stmt = $mysqli->prepare("SELECT * FROM users WHERE email = ?");\n$stmt->bind_param("s", $email);\n$stmt->execute();\n\n// Use htmlspecialchars to prevent XSS\necho htmlspecialchars($userInput, ENT_QUOTES, 'UTF-8');