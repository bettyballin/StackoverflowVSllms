$stmt = $pdo->prepare('SELECT * FROM users WHERE email = :email');\n    $stmt->execute(['email' => $email]);