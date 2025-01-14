function generateHash($input) {\n       return hash('sha256', $input);\n   }\n   \n   $item_id = 123;\n   $hash_value = generateHash($item_id);\n   \n   // Insert into database\n   $stmt = $pdo->prepare("INSERT INTO Users (username, item_id, item_id_hash) VALUES (?, ?, ?)");\n   $stmt->execute([$username, $item_id, $hash_value]);