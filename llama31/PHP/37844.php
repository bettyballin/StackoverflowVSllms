$stmt = $pdo->prepare("SELECT DISTINCT posts.id, posts.title, posts.content\n                       FROM posts\n                       WHERE NOT EXISTS (\n                         SELECT 1\n                         FROM tags\n                         WHERE tags.post_id = posts.id\n                         AND tags.tag LIKE :keywords\n                       )");\n\n$stmt->bindParam(':keywords', $keywords);\n$stmt->execute();