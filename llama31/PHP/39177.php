<?php\nsession_start();\nif (!isset($_SESSION['authenticated'])) {\n    header('Location: login.php');\n    exit;\n}\n// Display the protected content\n?>