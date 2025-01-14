session_start();\n\n// Generate a CSRF token and store it in the session\nif (!isset($_SESSION['csrf_token'])) {\n    $_SESSION['csrf_token'] = bin2hex(random_bytes(32));\n}\n\n$csrfTokenFromForm = $_SERVER['HTTP_X_CSRF_TOKEN'];\n$storedCsrfToken = $_SESSION['csrf_token'];\n\n// Validate CSRF token\nif (hash_equals($storedCsrfToken, $csrfTokenFromForm)) {\n    // Process the request\n} else {\n    http_response_code(403);\n    echo "Invalid CSRF token.";\n    exit();\n}