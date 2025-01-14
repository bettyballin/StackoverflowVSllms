// Moodle (validate token)\nsession_start();\n$secret_key = 'your_secret_key'; // Must match the one used in Joomla\n\nif (!isset($_GET['token']) || !isset($_GET['user_id'])) {\n    die('Invalid request.');\n}\n\n$user_id = $_GET['user_id'];\n$received_token = urldecode($_GET['token']);\n$timestamp = time();\n\n// Generate expected token for verification\n$expected_token = hash_hmac('sha256', $user_id . ',' . ($timestamp - 300), $secret_key);\n\nif (hash_equals($expected_token, $received_token)) {\n    // Token is valid, log user in and redirect to Moodle's main page\n    $_SESSION['user'] = ['id' => $user_id];\n    header('Location: /index.php');\n    exit();\n} else {\n    die('Invalid or expired token.');\n}