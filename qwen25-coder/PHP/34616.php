$pattern = '/^[\p{L} \'-]+$/u';\nif (preg_match($pattern, $name)) {\n    echo "The name is valid.";\n} else {\n    echo "Invalid characters found in the name.";\n}