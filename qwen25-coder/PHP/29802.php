<?php\ninclude('session_manager.php');\n\nif (!isset($_SESSION['site_user_country']) || $_SESSION['site_user_country'] == '') {\n    include('File1.php'); // Include File1 only if the session variable is not set.\n}\n// Rest of File2's code...\n?>