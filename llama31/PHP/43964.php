$pdo->setAttribute(PDO::MYSQL_ATTR_FOUND_ROWS, true);\n$stmt = $pdo->prepare('SELECT * FROM your_table WHERE your_conditions');\n$stmt->execute($params);\n$rowCount = $stmt->rowCount();