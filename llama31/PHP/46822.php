$stmt = $pdo->prepare('INSERT INTO users (username, password) VALUES (:username, :password)');\n$stmt->bindParam(':username', $username);\n$stmt->bindParam(':password', $hash, PDO::PARAM_LOB); // Bind as a binary value\n$stmt->execute();