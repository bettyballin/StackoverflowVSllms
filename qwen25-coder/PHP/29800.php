<?php\n\nfunction generateUniqueUsername($firstName, $lastName, $dbConnection) {\n    // Create base username from initials and last name\n    $baseUsername = strtolower(substr($firstName, 0, 1)) . substr($lastName, 0, 8);\n    \n    // Generate a random string to append\n    $randomStringLength = 4;\n    $characters = 'abcdefghijklmnopqrstuvwxyz';\n    $randomString = '';\n    for ($i = 0; $i < $randomStringLength; $i++) {\n        $index = rand(0, strlen($characters) - 1);\n        $randomString .= $characters[$index];\n    }\n    \n    // Complete username\n    $username = $baseUsername . $randomString;\n    \n    // Check if the username is unique in the database\n    $stmt = $dbConnection->prepare("SELECT COUNT(*) as count FROM users WHERE username = ?");\n    $stmt->bind_param('s', $username);\n    $stmt->execute();\n    $result = $stmt->get_result()->fetch_assoc();\n    \n    // If it's not unique, generate another one\n    while ($result['count'] > 0) {\n        $randomString = '';\n        for ($i = 0; $i < $randomStringLength; $i++) {\n            $index = rand(0, strlen($characters) - 1);\n            $randomString .= $characters[$index];\n        }\n        $username = $baseUsername . $randomString;\n        \n        $stmt->bind_param('s', $username);\n        $stmt->execute();\n        $result = $stmt->get_result()->fetch_assoc();\n    }\n    \n    return $username;\n}\n\n// Example usage:\n// Assuming you have a valid database connection\n$dbConnection = new mysqli("host", "user", "password", "database");\n$username = generateUniqueUsername('John', 'Smith', $dbConnection);\necho "Generated Username: " . $username;\n\n?>