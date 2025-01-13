if ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Check if the token is valid\n    if (!isset($_POST['csrf_token']) || $_POST['csrf_token'] !== $_SESSION['csrf_token']) {\n        // Invalid token, stop processing the form\n        die('Invalid request');\n    }\n\n    // Token is valid, process the form data\n    // ...\n}