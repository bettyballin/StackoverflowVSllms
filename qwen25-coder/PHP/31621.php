<?php\n// Start the session\nsession_start();\n\n// Check if the user is logged in by checking the username session variable\nif (isset($_SESSION['username'])) {\n    // The user is logged in, retrieve the username\n    $username = $_SESSION['username'];\n    echo "User is logged in as: " . htmlspecialchars($username);\n} else {\n    // The user is not logged in\n    echo "No user is currently logged in.";\n}\n?>