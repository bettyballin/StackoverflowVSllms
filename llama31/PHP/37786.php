// Check if the token is valid and matches the one set in request.php\nif (isset($_GET['token']) && $_GET['token'] === 'your_secret_token') {\n    // Allow the download\n    header('Content-Type: application/pdf');\n    header('Content-Disposition: attachment; filename="' . basename($_GET['file']) . '"');\n    readfile($_GET['file']);\n    exit;\n} else {\n    // Redirect back to the form if the token is invalid or missing\n    header('Location: request.php?file=' . $_GET['file']);\n    exit;\n}