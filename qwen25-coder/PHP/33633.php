<?php\nsession_start();\ninclude("base.php");\ninclude("userclass.php");\n\n$User = new User();\n$User->loggedin = false;\n\n$_SESSION = array(); // Unset all session variables\nif (ini_get("session.use_cookies")) {\n    $params = session_get_cookie_params();\n    setcookie(session_name(), '', time() - 42000,\n        $params["path"], $params["domain"],\n        $params["secure"], $params["httponly"]\n    );\n}\nsession_destroy(); // Destroy the session\nheader('Location: login.php');\nexit; // Make sure to exit after redirecting\n?>