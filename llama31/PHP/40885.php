<?php\nfunction sanitize($input) {\n    $input = trim($input);\n    $input = htmlspecialchars($input, ENT_QUOTES, 'UTF-8');\n    $input = strip_tags($input);\n    return $input;\n}\n?>