$headers = getallheaders();\n$authorizationHeader = $headers['Authorization'];\n\n// Or, to make it case-insensitive:\n$authorizationHeader = null;\nforeach ($headers as $key => $value) {\n    if (strtolower($key) == 'authorization') {\n        $authorizationHeader = $value;\n        break;\n    }\n}