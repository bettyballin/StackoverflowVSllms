// Example of processing and displaying the submitted form data\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    // Get the submitted text\n    $input_text = $_POST['textarea_name'];\n    \n    // Sanitize the input\n    $input_text = htmlspecialchars($input_text, ENT_QUOTES, 'UTF-8');\n    \n    // Convert newlines to <br> tags\n    $input_text_with_br = nl2br($input_text);\n    \n    // Output the sanitized and formatted text\n    echo $input_text_with_br;\n}