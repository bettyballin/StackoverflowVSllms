// Set the session variable securely\n$_SESSION['auth_level'] = $auth_level;\n\n// Validate the session variable on each request\nif (isset($_SESSION['auth_level']) && is_numeric($_SESSION['auth_level'])) {\n    $auth_level = $_SESSION['auth_level'];\n} else {\n    // Handle invalid session variable\n}