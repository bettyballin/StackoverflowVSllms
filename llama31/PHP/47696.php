$page = $_GET['page'];\n$per = 10;\n\n// Retrieve the first batch of results\n$stmt = $pdo->prepare('SELECT * FROM table WHERE conditions ORDER BY id LIMIT :per');\n$stmt->bindParam(':per', $per);\n$stmt->execute();\n$results = $stmt->fetchAll();\n\n// Get the last retrieved ID\n$lastId = $results[count($results) - 1]['id'];\n\n// Display results\n\n// Show next link if there are more results\nif ($pdo->query('SELECT 1 FROM table WHERE conditions AND id > :lastId LIMIT 1')->fetch()) {\n    echo '<a href="?page=' . ($page + 1) . '">Next</a>';\n}