// buy2.php\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    // Validate data\n    if (/* validation successful */) {\n        // Save data to session\n        $_SESSION['post_data_2'] = $_POST;\n        // Redirect to buy3.php (or check.php if it's the last page)\n        header('Location: buy3.php', true, 303);\n        exit;\n    } else {\n        // Display errors\n    }\n}