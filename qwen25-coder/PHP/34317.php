$input = array('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j');\n\n$output = array_values(array_filter($input, function($key) {\n    return $key % 2 === 0;\n}, ARRAY_FILTER_USE_KEY));\n\nvar_dump($output);