$allowedChars = '/^[a-zA-Z0-9\/\?\=\(\)\&\-\_\.]+$/';\n$uri = $_SERVER['REQUEST_URI'];\n\nif (preg_match($allowedChars, $uri)) {\n    echo $uri;\n} else {\n    // Handle invalid input\n}