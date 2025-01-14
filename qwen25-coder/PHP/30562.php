<?php\ntry {\n    // Establishing connection with your database server\n    $pdo = new PDO('mysql:host=localhost;dbname=your_database_name', 'username', 'password');\n    // Setting the error mode attribute\n    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);\n\n    // SQL query to fetch categories and forums associated\n    $stmt = $pdo->query("\n        SELECT c.id AS cat_id, c.name AS cat_name, f.id AS forum_id, f.name AS forum_name, f.description\n        FROM categories c\n        LEFT JOIN forums f ON c.id = f.cat_id\n        ORDER BY c.position, f.position\n    ");\n\n    // Fetching results\n    $categories = [];\n    while ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n        if (!isset($categories[$row['cat_id']])) {\n            $categories[$row['cat_id']] = [\n                'name' => htmlspecialchars($row['cat_name']),\n                'forums' => []\n            ];\n        }\n        if ($row['forum_id']) { // Ensure we have a forum to add\n            $categories[$row['cat_id']]['forums'][] = [\n                'id' => $row['forum_id'],\n                'name' => htmlspecialchars($row['forum_name']),\n                'description' => htmlspecialchars($row['description'])\n            ];\n        }\n    }\n\n    // Displaying the categories and forums\n    foreach ($categories as $category) {\n        echo "<h2>" . $category['name'] . "</h2>\n";\n        echo "<ul>\n";\n        foreach ($category['forums'] as $forum) {\n            echo "<li><strong>" . $forum['name'] . ":</strong> " . $forum['description'] . "</li>\n";\n        }\n        echo "</ul>\n";\n    }\n\n} catch (PDOException $e) {\n    die("Could not connect to the database: " . $e->getMessage());\n}\n?>