<?php\nsession_start();\n\nif (!isset($_SESSION['user'])) {\n    header("Location: /login.php");\n    exit();\n}\n?>