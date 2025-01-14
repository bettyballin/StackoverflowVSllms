$db->beginTransaction();\n\ntry {\n    // Insert the new member with a temporary order value\n    $db->query('INSERT INTO members (id, name, `order`) VALUES (0, "new member", 0)');\n    $lastId = $db->lastInsertId();\n    \n    // Get the maximum current order\n    $maxOrder = $db->fetchAll('SELECT MAX(`order`) max_order FROM members');\n    \n    // Update the new member's order to be next in line\n    $newOrder = isset($maxOrder[0]['max_order']) ? $maxOrder[0]['max_order'] + 1 : 1;\n    $db->query('UPDATE members SET `order` = ? WHERE id = ?', [$newOrder, $lastId]);\n    \n    // Commit the transaction\n    $db->commit();\n} catch (Exception $e) {\n    // Rollback in case of an error\n    $db->rollback();\n    throw $e;\n}