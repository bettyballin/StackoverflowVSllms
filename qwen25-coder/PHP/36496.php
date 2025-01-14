<?php\n$search_keywords = $_GET["search_keywords"];\n\n// Assuming $pdo is your PDO connection object\n$stmt = $pdo->prepare("SELECT * FROM movies WHERE mov_title LIKE :keyword");\n$pattern = "%" . $search_keywords . "%"; // Add wildcard characters for partial search\n\n$stmt->bindParam(':keyword', $pattern, PDO::PARAM_STR);\n$stmt->execute();\n\n$results = $stmt->fetchAll();\n?>