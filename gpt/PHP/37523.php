<?php\n// Protected route (protected.php)\ninclude 'auth.php';\n\nif (!isAuthenticated()) {\n    die('Access denied');\n}\n\necho "Welcome to the protected page!";\n?>