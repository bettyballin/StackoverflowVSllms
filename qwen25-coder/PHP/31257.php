<?php\n// Retrieve the raw query string without parsing\n$queryString = $_SERVER['QUERY_STRING'];\n\n// Check if the query string starts with '=' which indicates no key is defined\nif (substr($queryString, 0, 1) === '=') {\n    // Remove the '=' to get the file name\n    $file = substr($queryString, 1);\n\n    // Validate and sanitize the file name to prevent directory traversal attacks\n    $validFiles = ['file.exe', 'anotherfile.txt']; // List of valid files\n    if (in_array($file, $validFiles)) {\n        // Proceed with downloading the file\n        header('Content-Type: application/octet-stream');\n        header('Content-Disposition: attachment; filename="' . basename($file) . '"');\n        readfile($file);\n    } else {\n        http_response_code(403); // Forbidden access\n        echo "Error: Invalid or forbidden file.";\n    }\n} else {\n    http_response_code(400); // Bad request\n    echo "Error: Invalid query format.";\n}\n?>