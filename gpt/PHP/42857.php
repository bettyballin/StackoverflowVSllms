<?php\nsession_start();\nif (isset($_SESSION['username']) && isset($_SESSION['password'])) {\n    $username = $_SESSION['username'];\n    $password = $_SESSION['password'];\n\n    // Use the session variables as needed\n    echo "Welcome, " . htmlspecialchars($username) . "!";\n\n    // For security, consider unsetting the session variables after use\n    unset($_SESSION['username']);\n    unset($_SESSION['password']);\n} else {\n    echo "No session data found. Please log in.";\n}\n?>