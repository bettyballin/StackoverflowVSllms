// Temporary patch: Apply htmlspecialchars to superglobal arrays\n$_POST = array_map('htmlspecialchars', $_POST);\n$_COOKIE = array_map('htmlspecialchars', $_COOKIE);\n$_GET = array_map('htmlspecialchars', $_GET);