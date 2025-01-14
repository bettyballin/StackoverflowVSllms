$stmt = $pdo->query("SELECT post_content, post_title FROM your_table");\n\nwhile ($row = $stmt->fetch(PDO::FETCH_ASSOC)) {\n    // Accessing 'Post Content' and 'Post Title'\n    $postContent = $row['post_content'];\n    $postTitle = $row['post_title'];\n\n    // Output or process the values\n    echo "Post Title: " . htmlspecialchars($postTitle) . "\n";\n    echo "Post Content: " . htmlspecialchars($postContent) . "\n";\n}