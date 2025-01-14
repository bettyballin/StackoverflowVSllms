function filter_user_input($input) {\n    // Allow <b> and <br> tags, and remove all other tags\n    $allowed_tags = '<b><br>';\n    $input = strip_tags($input, $allowed_tags);\n\n    // Convert special characters to HTML entities\n    $input = htmlspecialchars($input, ENT_QUOTES, 'UTF-8');\n\n    return $input;\n}\n\n// Example usage\n$user_input = '<b>Bold Text</b> <script>alert("XSS")</script> <br> Line Break';\n$filtered_input = filter_user_input($user_input);\n\necho $filtered_input;