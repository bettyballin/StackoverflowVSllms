// authenticate.php\nsession_start();\nif (!isset($_SESSION['user_id'])) {\n    header("Location: login.php");\n    exit();\n}\n\n// page.php\ninclude 'authenticate.php';\n// Page content for authenticated users