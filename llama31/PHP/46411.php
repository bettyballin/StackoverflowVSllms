// votes.php\n$token = $_SERVER['HTTP_X_AUTH_TOKEN'];\nif (!validateToken($token)) {\n    http_response_code(401);\n    echo 'Invalid token.';\n    exit;\n}