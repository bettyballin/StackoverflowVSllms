function markNewsAsRead($userId, $newsItemId) {\n        global $conn;\n        $stmt = $conn->prepare("INSERT INTO user_reading_status (user_id, news_item_id) VALUES (?, ?) ON DUPLICATE KEY UPDATE read = CURRENT_TIMESTAMP");\n        $stmt->bind_param("ii", $userId, $newsItemId);\n        $stmt->execute();\n    }