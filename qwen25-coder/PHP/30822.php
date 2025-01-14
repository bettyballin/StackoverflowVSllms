function addUser($email) {\n    $password = generatePassword();\n    $passwordHash = password_hash($password, PASSWORD_BCRYPT);\n\n    // Store the email and hashed password in your database here\n    // Example using PDO:\n    $stmt = $pdo->prepare("INSERT INTO users (email, password_hash) VALUES (:email, :password)");\n    $stmt->execute([':email' => $email, ':password' => $passwordHash]);\n\n    return ['email' => $email, 'password' => $password];\n}