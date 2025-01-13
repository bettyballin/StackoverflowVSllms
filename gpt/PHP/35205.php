// Start the session\nsession_start();\n\n// Regenerate session ID to prevent session fixation\nsession_regenerate_id(true);\n\n// Set session variables upon successful login\n$_SESSION['logged_in'] = true;\n$_SESSION['username'] = $username; // Store only essential information\n\n// Set session cookie parameters\n$params = session_get_cookie_params();\nsession_set_cookie_params([\n    'lifetime' => $params['lifetime'],\n    'path' => $params['path'],\n    'domain' => $params['domain'],\n    'secure' => true, // Ensure the cookie is sent over HTTPS\n    'httponly' => true, // Prevent JavaScript access to the session cookie\n    'samesite' => 'Strict' // Prevent CSRF attacks\n]);\n\n// Check if the user is logged in\nif (isset($_SESSION['logged_in']) && $_SESSION['logged_in'] === true) {\n    // Do whatever you want\n} else {\n    // Redirect to login page or show an error\n    header('Location: login.php');\n    exit;\n}