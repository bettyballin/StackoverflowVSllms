<?php\n$file = fopen("example.txt", "r");\n\nif (is_resource($file) && get_resource_type($file) === 'stream') {\n    echo "The variable contains a file pointer.";\n} else {\n    echo "The variable does not contain a file pointer.";\n}\n\nfclose($file);\n?>