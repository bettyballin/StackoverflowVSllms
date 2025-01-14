// Assuming you are using PHP for your application\n\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    // Process and store form data\n    $id = processFormData($_POST);\n\n    // Redirect user after successful POST request\n    header('Location: page.php?id=' . urlencode($id));\n    exit();\n}\n\nfunction processFormData($data) {\n    // Your logic to handle the post data\n    return 1; // Example ID returned from processing\n}