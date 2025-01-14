<?php\nsession_start();\nrequire 'database.php'; // Assume this connects to your database\n\n// Function to update user's last activity timestamp.\nfunction updateLastActivity($userId) {\n    $conn = new mysqli(DB_SERVER, DB_USERNAME, DB_PASSWORD, DB_NAME);\n    if ($conn->connect_error) die("Connection failed: " . $conn->connect_error);\n\n    $stmt = $conn->prepare("INSERT INTO user_sessions (user_id) VALUES (?) ON DUPLICATE KEY UPDATE last_activity=NOW()");\n    $stmt->bind_param("i", $userId);\n    $stmt->execute();\n\n    $stmt->close();\n    $conn->close();\n}\n\n// Example usage: Call this function whenever a page is loaded or action is performed.\n$user_id = $_SESSION['user_id']; // Assume user ID is stored in session\nupdateLastActivity($user_id);\n?>