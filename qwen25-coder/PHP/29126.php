<?php\n    // index.php\n\n    // Get the request URI\n    $request_uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\n\n    // Define routes here\n    $routes = [\n        '/reports/' => 'reportHandler.php',\n        '/secure/do' => 'secureHandler.php'\n    ];\n\n    // Check if the requested route exists and include it\n    if (array_key_exists($request_uri, $routes)) {\n        require_once $routes[$request_uri];\n    } else {\n        http_response_code(404);\n        echo "404 Not Found";\n        exit;\n    }\n    ?>