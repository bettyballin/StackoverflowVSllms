// Prepare a statement\n$stmt = $pdo->prepare("INSERT INTO my_table (id, name) VALUES (?, ?)");\n\n// Execute the statement with parameters\n$stmt->execute([1, 'example']);