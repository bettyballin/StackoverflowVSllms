session_start();\n\nif (!isset($_SESSION['pageCounter'])) {\n    $_SESSION['pageCounter'] = 0;\n}\n\n$_SESSION['pageCounter']++;\n\n// Check if the counter has reached the desired value\nif ($_SESSION['pageCounter'] >= X) {\n    // Perform the desired action\n}