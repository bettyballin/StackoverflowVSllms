function prevent_direct_access()\n{\n    if ($_SERVER['REQUEST_URI'] == $_SERVER['PHP_SELF']) {\n        header("HTTP/1.0 404 Not Found");\n        include_once('404.php');\n        exit();\n    }\n}