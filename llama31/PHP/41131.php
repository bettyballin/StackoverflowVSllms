<?php\nfunction sanitize($input) {\n    $input = trim($input);\n    $input = strip_tags($input);\n    return $input;\n}\n?>