if (get_magic_quotes_gpc()) {\n    // Turn off magic quotes for GET/POST/Cookie data\n    $_GET = array_map('stripslashes', $_GET);\n    $_POST = array_map('stripslashes', $_POST);\n    $_COOKIE = array_map('stripslashes', $_COOKIE);\n}