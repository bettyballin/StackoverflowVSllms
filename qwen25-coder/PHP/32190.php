// index.php (start session and pass user)\n<?php\nsession_start();\nif (isset($_GET['user'])) {\n    $_SESSION['user'] = $_GET['user'];\n}\n\ninclude 'about.php';\ninclude 'profile.php';\n?>