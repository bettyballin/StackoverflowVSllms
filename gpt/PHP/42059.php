<?php\n// Database connection\n$mysqli = new mysqli("hostname", "username", "password", "database");\n\nif ($mysqli->connect_error) {\n    die("Connection failed: " . $mysqli->connect_error);\n}\n\n// Fetch created times\n$created_query = "SELECT MIN(action_logs.time_added) AS created_time, article.number AS articleNum\n                 FROM action_logs\n                 JOIN article ON action_logs.article_num = article.number\n                 WHERE action_logs.message LIKE '%added%'\n                 GROUP BY article.number";\n$created_result = $mysqli->query($created_query);\n\n// Fetch modified times\n$modified_query = "SELECT MAX(action_logs.time_added) AS modified_time, article.number AS articleNum\n                  FROM action_logs\n                  JOIN article ON action_logs.article_num = article.number\n                  WHERE action_logs.message LIKE '%updated%'\n                  GROUP BY article.number";\n$modified_result = $mysqli->query($modified_query);\n\n// Prepare the final associative array\n$article_logs = [];\n\n// Process created times\nwhile ($row = $created_result->fetch_assoc()) {\n    $articleNum = $row['articleNum'];\n    $article_logs[$articleNum]['created'] = $row['created_time'];\n    $article_logs[$articleNum]['modified'] = null; // default to null for modified\n}\n\n// Process modified times\nwhile ($row = $modified_result->fetch_assoc()) {\n    $articleNum = $row['articleNum'];\n    if (isset($article_logs[$articleNum])) {\n        $article_logs[$articleNum]['modified'] = $row['modified_time'];\n    } else {\n        $article_logs[$articleNum] = [\n            'created' => null, // default to null for created\n            'modified' => $row['modified_time']\n        ];\n    }\n}\n\n// Close the connection\n$mysqli->close();\n\n// Output the result\nprint_r($article_logs);\n?>