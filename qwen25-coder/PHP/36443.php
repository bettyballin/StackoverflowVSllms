<?php\nfunction doLogin($username, $password) {\n    include("connection.php");\n    \n    // Start the session\n    session_start();\n\n    try { \n        // Prepare a statement to execute\n        $stmt = $pdo->prepare('SELECT * FROM users WHERE username = :username AND password = :password');\n        \n        // Execute it, returning a PDOStatement object on success or false on failure\n        $stmt->execute([':username' => $username, ':password' => hash_password($password)]);\n\n        // Fetch the row that matched the query.\n        $result = $stmt->fetch();\n\n        if (!$result) {\n            session_unset();\n            return 'no';\n        } else {\n            $_SESSION['id'] = session_id();\n            $_SESSION['username'] = $username;\n            return 'yes';\n        }\n    } catch (PDOException $e) {\n        echo "Error: " . $e->getMessage();\n        return 'no';\n    }\n}\n\nfunction Logout() {\n    session_start();\n    session_unset(); // Unset all session variables\n    session_destroy(); // Destroy the session itself\n    return 'logout';      \n}\n\n// Function to hash password. Modify this according to your hashing mechanism.\nfunction hash_password($password) {\n    return password_hash($password, PASSWORD_DEFAULT);\n}\n?>