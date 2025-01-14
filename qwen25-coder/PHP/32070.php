$response = $item['response'];\n\n// Ensure the response is not corrupted\nif (preg_match('/^a:\d+:\{.*\}$/', $response)) {\n    // Attempt to unserialize only if the format looks correct\n    $data = @unserialize($response);\n    if ($data === false && $response !== 'b:0;') {  // Check for false result and not boolean false serialized\n        echo "unserialize() failed for some reason";\n    } else {\n        print_r($data);\n    }\n} else {\n    echo "Invalid serialized data format";\n}