// Getting the article IDs and their titles\n$query = "\n    SELECT DISTINCT p.page_id, p.page_title\n    FROM revision r\n    JOIN page p ON r.rev_page = p.page_id\n    WHERE p.page_namespace = 0\n      AND r.rev_user = {$userId}\n    ORDER BY r.rev_timestamp DESC\n    LIMIT 3\n";\n\n// Execute the query\n$result = $db->query($query);\n\n// Fetch the results\n$lastEditedArticles = [];\nwhile ($row = $result->fetch_assoc()) {\n    $lastEditedArticles[] = [\n        'page_id' => $row['page_id'],\n        'page_title' => $row['page_title']\n    ];\n}