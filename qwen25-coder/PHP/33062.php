<?php\n// Check if the variable is provided\nif (isset($argv[1])) {\n    $var = $argv[1];\n    echo "The value of var is: " . htmlspecialchars($var);\n} else {\n    echo "No variable was provided.";\n}\n?>