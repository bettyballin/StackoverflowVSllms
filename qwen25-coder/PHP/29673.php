<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $firstName = filter_input(INPUT_POST, 'first_name', FILTER_SANITIZE_STRING);\n    // Process your input here\n    echo "Hello, $firstName!";\n}\n?>