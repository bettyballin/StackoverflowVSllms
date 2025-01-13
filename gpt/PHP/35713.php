$timeout = 5; // Time in minutes\n\n// Database connection\n$pdo = new PDO('mysql:host=localhost;dbname=your_database', 'username', 'password');\n\n// Select users active within the timeout period\n$stmt = $pdo->prepare("SELECT user_id FROM user_sessions WHERE last_activity >= NOW() - INTERVAL :timeout MINUTE");\n$stmt->execute([':timeout' => $timeout]);\n\n$onlineUsers = $stmt->fetchAll(PDO::FETCH_COLUMN);