function logToDatabase($pdo, $userAction) {\n    $stmt = $pdo->prepare("INSERT INTO user_actions (action, created_at) VALUES (:action, NOW())");\n    $stmt->execute([':action' => $userAction]);\n}