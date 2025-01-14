function get_mkdir_error($path) {\n    $error = '';\n    ob_start(); // Start output buffering\n    $success = @mkdir($path); // Suppress default error message with @\n    \n    if (!$success) {\n        $error = trim(ob_get_contents()); // Capture the error message\n    }\n    ob_end_clean(); // Clean and end output buffering\n    \n    return [$success, $error];\n}\n\nlist($success, $errorMessage) = get_mkdir_error('/somedir');\n\nif (!$success) {\n    echo "MKDIR failed, reason: $errorMessage";\n}