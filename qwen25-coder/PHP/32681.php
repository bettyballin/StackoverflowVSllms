$headers = [];\nforeach ($_SERVER as $name => $value) {\n    if (substr($name, 0, 5) == 'HTTP_') {\n        $headers[str_replace(' ', '-', ucwords(strtolower(str_replace('_', ' ', substr($name, 5)))))] = $value;\n    }\n}\n// Manually add other headers not covered by HTTP_\nif (isset($_SERVER['CONTENT_TYPE'])) {\n    $headers['Content-Type'] = $_SERVER['CONTENT_TYPE'];\n}\nif (isset($_SERVER['CONTENT_LENGTH'])) {\n    $headers['Content-Length'] = $_SERVER['CONTENT_LENGTH'];\n}\n\nprint_r($headers);