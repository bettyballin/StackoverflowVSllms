function subst($str, $dict){\n    return preg_replace(array_map(create_function('$a', 'return "/%\\($a\\)s/";'), array_keys($dict)), array_values($dict), $str);\n }