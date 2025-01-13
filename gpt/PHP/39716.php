function getBaseUrl($url) {\n    $parsedUrl = parse_url($url);\n\n    $scheme = isset($parsedUrl['scheme']) ? $parsedUrl['scheme'] . '://' : '';\n    $host = isset($parsedUrl['host']) ? $parsedUrl['host'] : '';\n\n    return $scheme . $host;\n}\n\n// Example usage:\n$inputUrl = 'http://stackoverflow.com/question/ask/asdfasneransea';\n$baseUrl = getBaseUrl($inputUrl);\n\necho $baseUrl; // Outputs: http://stackoverflow.com