$stmt = $pdo->prepare('SELECT * FROM users WHERE name = :name');\n$stmt->bindParam(':name', $name);\n$stmt->execute();\n\n$stmt->debugDumpParams();\n$params = $stmt->getParameters();\n\n$query = $stmt->queryString;\nforeach ($params as $param => $value) {\n    $query = preg_replace('/:' . $param . '/', $pdo->quote($value), $query);\n}\n\nprint($query);