<?php\nsession_start();\n\nfunction setRememberMe($userId) {\n    $token = bin2hex(random_bytes(16)); // Generate random token\n    $expirationTime = time() + 86400 * 30; // Token expires in 30 days\n\n    // Store the token and expiration in the database (pseudo-code)\n    // insertTokenToDatabase($userId, $token, $expirationTime);\n\n    // Set cookie for client's browser\n    setcookie('remember_me', "$userId:$token", [\n        'expires' => $expirationTime,\n        'path' => '/',\n        'secure' => true,  // Only send the cookie over HTTPS\n        'httponly' => true,  // Prevent JavaScript from accessing the cookie\n        'samesite' => 'Strict'\n    ]);\n}\n\nif (isset($_POST['remember_me'])) {\n    setRememberMe($_SESSION['user_id']);\n}\n?>