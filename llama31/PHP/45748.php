function isAlphanumeric($string) {\n    return preg_match('/^[a-zA-Z0-9]+$/', $string) === 1;\n}