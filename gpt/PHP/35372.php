<?php\n// List of approved domains\n$approved_domains = [\n    'https://approvedsite1.com',\n    'https://approvedsite2.com'\n];\n\n$referer = isset($_SERVER['HTTP_REFERER']) ? $_SERVER['HTTP_REFERER'] : '';\n\n// Check if the referer is in the list of approved domains\n$allowed = false;\nforeach ($approved_domains as $domain) {\n    if (strpos($referer, $domain) === 0) {\n        $allowed = true;\n        break;\n    }\n}\n\n// Block access if not allowed\nif (!$allowed) {\n    header('HTTP/1.0 403 Forbidden');\n    echo 'You are not allowed to access this page.';\n    exit;\n}\n?>\n\n<!-- Your page content here -->\n<!DOCTYPE html>\n<html lang="en">\n<head>\n    <meta charset="UTF-8">\n    <title>Secure Iframe Content</title>\n</head>\n<body>\n    <h1>Welcome to the secure iframe content!</h1>\n</body>\n</html>