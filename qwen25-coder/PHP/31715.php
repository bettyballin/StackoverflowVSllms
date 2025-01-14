<?php\nfunction getBaseUrl($url) {\n    $parsedUrl = parse_url($url);\n    $scheme = isset($parsedUrl['scheme']) ? $parsedUrl['scheme'] . '://' : '';\n    $host = isset($parsedUrl['host']) ? $parsedUrl['host'] : '';\n    $port = isset($parsedUrl['port']) ? ':' . $parsedUrl['port'] : '';\n    \n    return $scheme . $host . $port;\n}\n\n// Example usage\n$userInput = 'http://stackoverflow.com/question/ask/asdfasneransea';\n$baseUrl = getBaseUrl($userInput);\necho $baseUrl; // Outputs: http://stackoverflow.com\n?>