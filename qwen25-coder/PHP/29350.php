$response = $foo; // your response string\n\n// Decode the JSON data\n$data = json_decode(trim($response), true);\n\n// Check for errors in decoding JSON\nif (json_last_error() !== JSON_ERROR_NONE) {\n    echo 'Error decoding JSON: ' . json_last_error_msg();\n} else {\n    var_dump($data);\n}