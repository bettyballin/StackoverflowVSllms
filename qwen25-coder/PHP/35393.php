<?php\n// Assuming $username is obtained from user input\n$username = $_POST['username'];\n$password = $_POST['password'];\n\n// Convert submitted username to lowercase for case-sensitive comparison\n$username = strtolower($username);\n\n// Prepare and execute the SQL query using prepared statements to prevent SQL injection\n$stmt = $pdo->prepare("SELECT * FROM users WHERE username = :username");\n$stmt->execute([':username' => $username]);\n$user = $stmt->fetch();\n\nif ($user && password_verify($password, $user['password'])) {\n    echo "Can login";\n} else {\n    echo "Login failed";\n}\n?>