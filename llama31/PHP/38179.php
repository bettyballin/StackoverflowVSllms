$stmt = $pdo->prepare('INSERT INTO table (column) VALUES (:value)');\n$stmt->bindParam(':value', $input);\n$stmt->execute();