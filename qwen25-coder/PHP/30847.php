$a = ['b' => null];\n\nif (array_key_exists('b', $a)) {\n    echo "'b' exists in the array.\n";\n} else {\n    echo "'b' does not exist in the array.\n";\n}\n\nif (array_key_exists('c', $a)) {\n    echo "'c' exists in the array.\n";\n} else {\n    echo "'c' does not exist in the array.\n";\n}