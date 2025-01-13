$stmt = $pdo->prepare("INSERT INTO users (username, password) VALUES (:username, :password)");\n   $stmt->execute([\n       ':username' => $username,\n       ':password' => password_hash($password, PASSWORD_BCRYPT)\n   ]);