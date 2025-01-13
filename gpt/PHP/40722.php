// Store value in database\n   $stmt = $pdo->prepare("INSERT INTO table (key, value) VALUES (:key, :value)");\n   $stmt->execute(['key' => 'key', 'value' => 'value']);\n   \n   // Retrieve value from database\n   $stmt = $pdo->prepare("SELECT value FROM table WHERE key = :key");\n   $stmt->execute(['key' => 'key']);\n   $value = $stmt->fetchColumn();