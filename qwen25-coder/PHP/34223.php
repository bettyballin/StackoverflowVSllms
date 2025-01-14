function getSubcategories($categoryId, $pdo) {\n    $stmt = $pdo->prepare("SELECT c.id, c.title FROM categories c JOIN category_closure cc ON c.id = cc.descendant WHERE cc.ancestor = :category_id");\n    $stmt->execute([':category_id' => $categoryId]);\n    return $stmt->fetchAll(PDO::FETCH_ASSOC);\n}\n\nfunction getPathToRoot($categoryId, $pdo) {\n    $stmt = $pdo->prepare("SELECT cc.ancestor AS parent_id, c.title FROM categories c JOIN category_closure cc ON c.id = cc.ancestor WHERE cc.descendant = :category_id ORDER BY cc.depth DESC");\n    $stmt->execute([':category_id' => $categoryId]);\n    return $stmt->fetchAll(PDO::FETCH_ASSOC);\n}