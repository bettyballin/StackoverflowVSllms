<?php\nsession_start();\nif (!isset($_SESSION['user_id'])) {\n    // Redirect to login page if not logged in\n    header('Location: login.php');\n    exit();\n}\n\n$user_id = $_SESSION['user_id'];\n// Now use $user_id to query the database for the user's widgets\n?>