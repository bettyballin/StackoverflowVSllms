$context = stream_context_create([\n    'http' => [\n        'timeout' => 10 // 10 seconds timeout\n    ]\n]);\n\n$response = file_get_contents('http://example.com/api', false, $context);