// On each page that requires authentication\nsession_start();\nif (!isset($_SESSION['user_id'])) {\n    if (isset($_COOKIE['auth_token'])) {\n        // Validate the token against database\n        $token = $_COOKIE['auth_token'];\n        $stmt = $db->prepare('SELECT id FROM users WHERE auth_token = :token');\n        $stmt->execute([':token' => hash('sha256', $token)]);\n        $user = $stmt->fetch(PDO::FETCH_ASSOC);\n\n        if ($user) {\n            // Login successful\n            $_SESSION['user_id'] = $user['id'];\n        }\n    }\n\n    if (!isset($_SESSION['user_id'])) {\n        // No session or cookie found, redirect to login\n        header('Location: login.php');\n        exit;\n    }\n}