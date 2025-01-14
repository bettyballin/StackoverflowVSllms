function getAllHeaders() {\n    $headers = [];\n    foreach ($_SERVER as $key => $value) {\n        if (substr($key, 0, 5) == 'HTTP_') {\n            // convert HTTP_HEADER_NAME to Header-Name\n            $headers[str_replace(' ', '-', ucwords(strtolower(str_replace('_', ' ', substr($key, 5)))))] = $value;\n        }\n    }\n\n    return $headers;\n}\n\n$headers = getAllHeaders();\n$authorizationHeader = isset($headers['Authorization']) ? $headers['Authorization'] : null;\n\n// Now you can use $authorizationHeader