// At the top of each PHP file\nsession_start();\n\n// In your error handling code\nif (error_condition) {\n    $_SESSION['error_id'] = 5;\n    header('Location: view_category.php?product_category_id=4');\n    exit();\n}\n\n// In view_category.php or any other target page\nif (isset($_SESSION['error_id'])) {\n    $error_id = $_SESSION['error_id'];\n    // Display error message based on $error_id\n    echo "Error encountered: Error ID - " . htmlspecialchars($error_id);\n    \n    // Unset the session variable to prevent re-display on refresh\n    unset($_SESSION['error_id']);\n}\n\n// Ensure you always start the session at the very beginning of your script