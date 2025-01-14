<?php\n// Target URL of the login form\n$url = "http://example.com/login.php";\n\n// Credentials for logging in\n$username = 'your_username';\n$password = 'your_password';\n\n// Initialize cURL session\n$ch = curl_init();\n\n// Set options for cURL\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_POST, 1);\ncurl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query(['username' => $username, 'password' => $password]));\ncurl_setopt($ch, CURLOPT_COOKIEJAR, 'cookie.txt'); // Save cookies in a cookie file\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// Execute cURL session\n$response = curl_exec($ch);\n$http_code = curl_getinfo($ch, CURLINFO_HTTP_CODE);\n\n// Check for errors and handle response\nif ($http_code == 200) {\n    // Successfully logged in\n    echo "Logged in successfully.\n";\n} else {\n    // Error occurred during login attempt\n    echo "Failed to log in. HTTP Code: $http_code\n";\n}\n\n// Close cURL session\ncurl_close($ch);\n?>