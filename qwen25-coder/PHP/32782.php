$stmt = $pdo->prepare("SELECT * FROM users WHERE email = :email AND reset_key = :key AND expiration > NOW()");\n   $stmt->execute([':email' => $email, ':key' => $key]);\n   $user = $stmt->fetch();