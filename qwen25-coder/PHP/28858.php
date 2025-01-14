<?php\n\nfunction path_is_valid($userPath) {\n    // Define the directory you want to restrict access to.\n    $baseDir = __DIR__ . '/sample';\n\n    // Normalize user input by prepending base directory and resolving any '..'.\n    $absolutePath = realpath($baseDir . '/' . $userPath);\n\n    // Check if the resolved path is still within the base directory.\n    return strpos($absolutePath, $baseDir) === 0;\n}\n\n$path = $_GET['path'];\nif(path_is_valid($path)) {\n    header('Content-Type: text/plain');\n    readfile("sample/$path");\n} else {\n    http_response_code(403);\n    echo "Access denied.";\n}\n?>