<?php\nsession_start();\n\n// Ensure this page is only accessible via GET after a POST submission and redirect\nif ($_SERVER['REQUEST_METHOD'] != 'GET') {\n    die('Invalid request method.');\n}\n\n// Check if form data from session is set, otherwise redirect to buy.php\nif (!isset($_SESSION['form_data'])) {\n    header("Location: buy.php");\n    exit();\n}\n\n$formData = $_SESSION['form_data'];\n$_SESSION['form_data'] = null; // Clear the data after displaying it once\n\n// Display data here for final check\necho "<h1>Review Your Order</h1>";\necho "Items: " . htmlspecialchars($formData['items']) . "<br>";\n// More fields...\n?>