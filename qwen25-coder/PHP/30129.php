$results = $pdo->query("SELECT n.*, c.* FROM news n LEFT JOIN comments c ON c.news_id = n.id ORDER BY n.id, c.id")->fetchAll(PDO::FETCH_ASSOC);\n\n$newsWithComments = [];\nforeach ($results as $row) {\n    $newsId = $row['id']; // Assuming 'id' is the primary key for news\n    if (!isset($newsWithComments[$newsId])) {\n        // Initialize the news item with comments array\n        $newsWithComments[$newsId] = [\n            'id' => $row['id'],\n            'title' => $row['title'], // Adjust fields according to your table schema\n            // Add other news fields here...\n            'comments' => []\n        ];\n    }\n\n    if ($row['comment_id'] !== null) { // Check if there is a comment associated\n        // Add the comment to the comments array of this news item\n        $newsWithComments[$newsId]['comments'][] = [\n            'id' => $row['comment_id'],\n            'content' => $row['content'],  // Adjust fields according to your table schema\n            // Add other comment fields here...\n        ];\n    }\n}\n\n$newsArray = array_values($newsWithComments);