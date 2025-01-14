$connection = new mysqli('hostname', 'username', 'password', 'database');\n\n$query = "\n    SELECT t.id, t.title, c.date AS last_comment_date\n    FROM threads t\n    LEFT JOIN (\n        SELECT thread_id, MAX(date) AS max_date\n        FROM comments\n        GROUP BY thread_id\n    ) c ON t.id = c.thread_id\n    ORDER BY c.max_date DESC, t.date DESC\n";\n\n$result = $connection->query($query);\n\nwhile ($thread = $result->fetch_assoc()) {\n    echo $thread['title'] . " - Last Comment: " . $thread['last_comment_date'];\n}\n\n$connection->close();