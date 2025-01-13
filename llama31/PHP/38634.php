function truncate_string($str, $length, $ending = '...') {\n    return strlen($str) > $length ? substr($str, 0, $length - strlen($ending)) . $ending : $str;\n}