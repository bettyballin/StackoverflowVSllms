<?php\nif ($_SERVER['REQUEST_METHOD'] === 'POST') {\n    $input = isset($_POST['input']) ? $_POST['input'] : '';\n    // Process the input as needed\n    echo "You typed: " . htmlspecialchars($input, ENT_QUOTES, 'UTF-8');\n}\n?>