<?php\n$string = 'This is a text, "Your Balance left $0.10", End 0';\n\npreg_match('/"([^"]+)"/', $string, $matches);\n\nif (isset($matches[1])) {\n    echo $matches[1]; // Output: Your Balance left $0.10\n} else {\n    echo "No match found.";\n}\n?>