$context = stream_context_create(array(\n    'http' => array(\n        'method' => 'GET',\n        'header' => 'Cache-Control: no-cache'\n    )\n));\n\n$fp = fopen('http://example.com/file.txt', 'r', false, $context);