$stmt = $pdo->prepare('SELECT * FROM your_table');\n$stmt->execute();\n$array = $stmt->fetchAll(PDO::FETCH_NAMED);\n$array = array_map('floatval', $array);