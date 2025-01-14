<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $commentId = intval($_POST['comment_id']);\n    $replyContent = filter_input(INPUT_POST, 'replycomment', FILTER_SANITIZE_STRING);\n\n    // Database connection (adjust parameters as necessary)\n    $conn = new mysqli('localhost', 'username', 'password', 'database');\n\n    if ($conn->connect_error) {\n        die("Connection failed: " . $conn->connect_error);\n    }\n\n    // Insert a reply into the database\n    $stmt = $conn->prepare("INSERT INTO replies (comment_id, content) VALUES (?, ?)");\n    $stmt->bind_param('is', $commentId, $replyContent);\n\n    if ($stmt->execute()) {\n        echo json_encode(['status' => 'success', 'reply_content' => htmlspecialchars($replyContent)]);\n    } else {\n        echo json_encode(['status' => 'error']);\n    }\n\n    $conn->close();\n} else {\n    http_response_code(405);\n}\n?>