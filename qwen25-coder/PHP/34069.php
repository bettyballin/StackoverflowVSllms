<?php\n// Assume $i and $p are fetched from GET request\n$i = $_GET['i'] ?? null;\n$p = $_GET['p'] ?? null;\n\nif (is_numeric($i) && ctype_alnum($p)) {\n    // Both validations pass, proceed with your code logic\n} else {\n    // Handle the case where validation fails\n    http_response_code(400); // Bad Request\n    echo "Invalid input. Please provide a valid integer for 'i' and alphanumerics for 'p'.";\n}\n?>