<?php\n\nfunction posts() {\n    echo "Viewing posts";\n}\n\n// Get the URI and remove leading/trailing slashes\n$uri = trim($_SERVER['REQUEST_URI'], '/');\n\n// Split the URI into parts\n$uriParts = explode('/', $uri);\n\n// Assume the last part is the function name\n$functionName = end($uriParts);\n\n// Check if the function exists and call it; otherwise, handle error\nif (function_exists($functionName)) {\n    $functionName();\n} else {\n    echo "404: Function not found";\n}\n\n?>