// PHP with PDO for demonstration purposes\n$connection = new PDO('mysql:host=localhost;dbname=testdb', 'user', 'password');\n$tagId = 1; // ID of the parent tag where you want to insert a child\n\n// Begin transaction\n$connection->beginTransaction();\n\n$stmt = $connection->prepare("SELECT rght FROM tags WHERE id=:id");\n$stmt->execute([':id' => $tagId]);\n$row = $stmt->fetch(PDO::FETCH_ASSOC);\n\n$newRight = $row['rght'];\n$newName = "New Tag";\n\n// Shift nodes to the right of parent node's right\n$connection->prepare("UPDATE tags SET rght=rght + 2, lft=lft + 2 WHERE rght >= :newRight")->execute([':newRight' => $newRight]);\n$connection->prepare("UPDATE tags SET rght=rght + 2 WHERE lft >= :newRight")->execute([':newRight' => $newRight]);\n\n// Insert new node\n$connection->prepare("INSERT INTO tags(name, parent_id, lft, rght) VALUES (:name, :parentId, :lft, :rght)")\n    ->execute([':name' => $newName, ':parentId' => $tagId, ':lft' => $newRight, ':rght' => $newRight + 1]);\n\n// Commit transaction\n$connection->commit();