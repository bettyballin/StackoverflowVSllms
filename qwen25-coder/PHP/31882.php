<?php\nfunction parseUserUrl($url) {\n    // Extract the part after the last slash\n    $path = parse_url($url, PHP_URL_PATH);\n    $parts = explode('/', trim($path, '/'));\n\n    if ($parts[0] === 'profile') {\n        // Assuming URL format is /john-adams-123\n        $identifier = end($parts);\n        $usernameAndId = explode('-', $identifier);\n\n        if (count($usernameAndId) >= 2) {\n            // Extract the username and ID\n            $username = implode('-', array_slice($usernameAndId, 0, -1));\n            $userId = end($usernameAndId);\n\n            return ['username' => $username, 'user_id' => $userId];\n        }\n    }\n\n    return null;\n}\n\n// Example usage\n$url = "https://me.com/john-adams-123";\n$userData = parseUserUrl($url);\n\nif ($userData) {\n    echo "Username: {$userData['username']}, User ID: {$userData['user_id']}";\n} else {\n    echo "Invalid URL format.";\n}\n?>