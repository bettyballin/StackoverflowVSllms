$stmt = $pdo->prepare('SELECT * FROM users WHERE name = :name');\n$stmt->execute([':name' => $userInput]);\n$results = $stmt->fetchAll();