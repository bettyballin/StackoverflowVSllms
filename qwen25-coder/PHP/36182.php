// Assuming you have a database connection stored in $db\n   $stmt = $db->prepare("INSERT INTO user_items (uid, item_id, item_hash) VALUES (?, ?, ?)");\n   $stmt->execute([$userId, $itemId, $itemHash]);