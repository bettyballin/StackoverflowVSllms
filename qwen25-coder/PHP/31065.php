if (get_magic_quotes_gpc()) {\n    $_GET     = array_map('stripslashes', $_GET);\n    $_POST    = array_map('stripslashes', $_POST);\n    $_COOKIE  = array_map('stripslashes', $_COOKIE);\n    $_REQUEST = array_map('stripslashes', $_REQUEST);\n}