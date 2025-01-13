<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $commentId = intval($_POST['comment_id']);\n    $replyText = trim($_POST['reply_text']);\n\n    if (!empty($commentId) && !empty($replyText)) {\n        // Database connection\n        $mysqli = new mysqli('hostname', 'username', 'password', 'database');\n\n        if ($mysqli->connect_error) {\n            die('Connection error: ' . $mysqli->connect_error);\n        }\n\n        // Insert the reply into the database\n        $stmt = $mysqli->prepare("INSERT INTO replies (comment_id, reply_text) VALUES (?, ?)");\n        $stmt->bind_param('is', $commentId, $replyText);\n\n        if ($stmt->execute()) {\n            echo json_encode(['success' => true]);\n        } else {\n            echo json_encode(['success' => false, 'message' => 'Database error']);\n        }\n\n        $stmt->close();\n        $mysqli->close();\n    } else {\n        echo json_encode(['success' => false, 'message' => 'Invalid input']);\n    }\n}\n?>