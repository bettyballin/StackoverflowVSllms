<?php\n// Hello World in PHP\necho "Hello, World!";\n\n// Variables\n$name = "John";\necho "Hello, $name!"; // Outputs: Hello, John!\n\n// Control Structure (If statement)\n$age = 18;\nif ($age >= 18) {\n    echo "$name is an adult.";\n} else {\n    echo "$name is not an adult yet.";\n}\n\n// Function\nfunction greet($username) {\n    return "Hello, $username!";\n}\necho greet("Jane"); // Outputs: Hello, Jane!\n?>