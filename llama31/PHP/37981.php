$stmt = $pdo->prepare('SELECT ... WHERE t1.id = :id');\n$stmt->bindParam(':id', $id);\n$stmt->execute();