// Generate a token and store it in the session\n$_SESSION['vote_token'] = bin2hex(random_bytes(16));\n\n// In your AJAX handler, verify the token\n$token = $_POST['token'];\nif (hash_equals($_SESSION['vote_token'], $token)) {\n    // Token is valid, process the vote\n} else {\n    // Token is invalid, reject the vote\n}