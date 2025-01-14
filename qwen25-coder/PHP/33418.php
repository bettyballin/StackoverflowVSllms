$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n$stmt = $pdo->query("\n    SELECT f.forum_name, f.forum_description, \n           (SELECT MAX(c.comment_date) \n            FROM comments c \n            JOIN threads t ON c.comment_thread_id = t.thread_id \n            WHERE t.forum_id = f.forum_id) AS last_post_date\n    FROM forums f\n    ORDER BY f.forum_order ASC\n");\n\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    echo "<h3>Forum: " . htmlspecialchars($row['forum_name']) . "</h3>";\n    echo "<div>Desc: " . htmlspecialchars($row['forum_description']) . "</div>";\n    if ($row['last_post_date'] !== null) {\n        echo "<div>Last post: " . $row['last_post_date'] . "</div>";\n    } else {\n        echo "<div>No posts yet.</div>";\n    }\n}