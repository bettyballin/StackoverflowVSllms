function getTagsByItem($itemId, $pdo) {\n    $stmt = $pdo->prepare("\n        SELECT t.*\n        FROM tags t\n        JOIN item_tags it ON t.tag_id = it.tag_id\n        WHERE it.item_id = :item_id\n    ");\n    $stmt->execute([':item_id' => $itemId]);\n    return $stmt->fetchAll(PDO::FETCH_ASSOC);\n}