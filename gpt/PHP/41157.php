<?php\nsession_start();\nif ($_SERVER['REQUEST_METHOD'] == 'POST') {\n    // Assuming you have verified the login credentials\n    $_SESSION['first_name'] = 'elvis';\n    $_SESSION['user_id'] = 2;\n    $_SESSION['user_level'] = 1;\n    header('Location: loggedin.php');\n    exit();\n}\n?>\n\n<!-- Your login form HTML here -->