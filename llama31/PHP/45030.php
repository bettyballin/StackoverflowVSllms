// delete.php\nsession_start();\n\nif (!isset($_SESSION['authenticated']) || $_SESSION['authenticated'] !== true) {\n    http_response_code(403); // Forbidden\n    echo 'Unauthorized access';\n    exit;\n}\n\n// Rest of your delete.php code