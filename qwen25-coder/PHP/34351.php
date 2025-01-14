<?php\n$servername = "localhost";\n$username = "yourusername";\n$password = "yourpassword";\n$dbname = "yourdatabase";\n\n// Create connection\n$conn = new mysqli($servername, $username, $password, $dbname);\n\nif ($conn->connect_error) {\n    die("Connection failed: " . $conn->connect_error);\n}\n\nfunction sanitizeInput($data) {\n    return htmlspecialchars(strip_tags(trim($data)), ENT_QUOTES, 'UTF-8');\n}\n\n// Handle Comment Submission\nif ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['action']) && $_POST['action'] === 'add_comment') {\n    $name = sanitizeInput($_POST['name']);\n    $comment_text = sanitizeInput($_POST['comment_text']);\n    $email = sanitizeInput($_POST['email']);\n    $parent_id = intval(isset($_POST['parent_id']) ? $_POST['parent_id'] : 0);\n    \n    // Insert comment into database\n    $sql = "INSERT INTO comments (name, email, comment_text, parent_id) VALUES (?, ?, ?, ?)";\n    if ($stmt = $conn->prepare($sql)) {\n        $stmt->bind_param("sssi", $name, $email, $comment_text, $parent_id);\n        $stmt->execute();\n    }\n}\n\n// Fetch Comments\nfunction fetchComments($pdo) {\n    global $conn;\n    $query = "SELECT * FROM comments WHERE parent_id=0 ORDER BY created_at ASC";\n    $result = $conn->query($query);\n\n    while ($row = $result->fetch_assoc()) {\n        echo '<div class="comment">';\n        echo '<b>' . $row['name'] . '</b>: ' . nl2br(makeLinksClickable($row['comment_text']));\n        echo '<form method="post" style="display:inline;">\n                <input type="hidden" name="action" value="add_comment">\n                <input type="hidden" name="parent_id" value="' . $row['id'] . '">\n                <input type="text" name="name" placeholder="Name" required>\n                <input type="email" name="email" placeholder="Email" required>\n                <textarea name="comment_text" rows="3" placeholder="Reply..." required></textarea>\n                <button type="submit">Submit Reply</button>\n              </form>';\n        echo '<div class="replies">';\n        fetchReplies($pdo, $row['id']);\n        echo '</div>';\n        echo '</div><br>';\n    }\n}\n\nfunction fetchReplies($pdo, $parent_id) {\n    global $conn;\n    $query = "SELECT * FROM comments WHERE parent_id=? ORDER BY created_at ASC";\n    if ($stmt = $conn->prepare($query)) {\n        $stmt->bind_param("i", $parent_id);\n        $stmt->execute();\n        $result = $stmt->get_result();\n        \n        while ($row = $result->fetch_assoc()) {\n            echo '<div class="reply">';\n            echo '<b>' . $row['name'] . '</b>: ' . nl2br(makeLinksClickable($row['comment_text']));\n            echo '</div>';\n        }\n    }\n}\n\nfunction makeLinksClickable($text) {\n    return preg_replace_callback(\n        '/\[(.*?)\]\((.*?)\)/i', \n        function ($matches) {\n            return '<a href="' . sanitizeInput($matches[2]) . '" target="_blank">' . sanitizeInput($matches[1]) . '</a>';\n        },\n        $text\n    );\n}\n\nfetchComments($conn);\n$conn->close();\n?>