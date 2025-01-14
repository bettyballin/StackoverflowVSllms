<?php\n$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n\n// First, get the count of rows in the table\n$stmt = $pdo->query("SELECT COUNT(*) FROM your_table");\n$rowCount = $stmt->fetchColumn();\n\n// Get a random id based on the row count\n$randomId = rand(1, $rowCount);\n\n// Now fetch the row with that offset\n$stmt = $pdo->prepare("SELECT * FROM your_table LIMIT :offset, 1");\n$stmt->bindValue(':offset', (int)$randomId - 1, PDO::PARAM_INT);\n$stmt->execute();\n\n$randomRow = $stmt->fetch(PDO::FETCH_ASSOC);\n\nprint_r($randomRow);\n?>