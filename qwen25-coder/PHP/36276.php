$stmt = $pdo->prepare("SELECT * FROM users WHERE id = :id");\n   $stmt->execute(['id' => $userId]);