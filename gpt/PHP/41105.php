<?php\nob_start();\nsession_start();\n\nif (!strpos($_SERVER['PHP_SELF'], 'loggedout.php')) {\n    if (isset($_COOKIE['access'])) {\n        header('Location: loggedin.php');\n        exit();\n    }\n} else {\n    // Destroy session on logged out page\n    $_SESSION = array();\n    session_destroy();\n    setcookie(session_name(), '', time() - 3600);\n}\n?>