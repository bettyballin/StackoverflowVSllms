// Function to sanitize input data from GET and POST\nfunction sanitizeInput($data) {\n    // Strip unnecessary whitespace\n    $data = trim($data);\n    \n    // Remove backslashes added by get_magic_quotes_gpc()\n    if (get_magic_quotes_gpc()) {\n        $data = stripslashes($data);\n    }\n    \n    // Convert special characters to HTML entities\n    return htmlspecialchars($data, ENT_QUOTES, 'UTF-8');\n}\n\nforeach ($_GET as $key => $value) {\n    $_GET[$key] = sanitizeInput($value);\n}\n\nforeach ($_POST as $key => $value) {\n    $_POST[$key] = sanitizeInput($value);\n}