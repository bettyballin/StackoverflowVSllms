$string = 'Hello, World!';\n$pattern = '/hello/i'; // Case-insensitive match\n\nif (preg_match($pattern, $string)) {\n    echo 'Match found!';\n} else {\n    echo 'No match found.';\n}