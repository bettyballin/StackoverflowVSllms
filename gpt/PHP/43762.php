if ($_SESSION['user_ip'] !== $_SERVER['REMOTE_ADDR'] || $_SESSION['user_agent'] !== $_SERVER['HTTP_USER_AGENT']) {\n       // Session hijacking attempt\n       session_destroy();\n       // Redirect to login\n   }