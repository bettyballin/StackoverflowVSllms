// buy.php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    // Validate data\n    if (/* validation successful */) {\n        // Save data to session\n        $_SESSION['post_data'] = $_POST;\n        // Redirect to check.php\n        header('Location: check.php', true, 303);\n        exit;\n    } else {\n        // Display errors\n    }\n}