<?php\nsession_start();\n\nif (!isset($_SESSION['MM_Username'])) {\n    header("Location: login.php");\n    exit();\n}\n\necho "Welcome, " . htmlspecialchars($_SESSION['MM_Username']) . ".";\n?>