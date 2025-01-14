function getUnreadNotifications($userId) {\n    $pdo = new PDO('mysql:host=localhost;dbname=your_db', 'username', 'password');\n    $stmt = $pdo->prepare("SELECT n.id, n.message FROM notifications AS n JOIN user_notifications AS un ON n.id = un.notification_id WHERE un.user_id = :user_id AND un.is_read = 0");\n    $stmt->execute([':user_id' => $userId]);\n    return $stmt->fetchAll();\n}\n\nfunction markNotificationAsRead($userId, $notificationId) {\n    $pdo = new PDO('mysql:host=localhost;dbname=your_db', 'username', 'password');\n    $stmt = $pdo->prepare("UPDATE user_notifications SET is_read = 1 WHERE user_id = :user_id AND notification_id = :notification_id");\n    $stmt->execute([':user_id' => $userId, ':notification_id' => $notificationId]);\n}