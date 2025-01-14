function getHttpStatusCode($url) {\n    $parsedUrl = parse_url($url);\n    $host = $parsedUrl['host'];\n    $path = isset($parsedUrl['path']) ? $parsedUrl['path'] : '/';\n    $query = isset($parsedUrl['query']) ? '?' . $parsedUrl['query'] : '';\n\n    // Open a socket connection\n    $fp = fsockopen($host, 80, $errno, $errstr, 30);\n    if (!$fp) {\n        return null; // or some error code\n    }\n\n    // Send the HTTP request\n    $out = "GET {$path}{$query} HTTP/1.1\r\n";\n    $out .= "Host: {$host}\r\n";\n    $out .= "Connection: Close\r\n\r\n";\n    fwrite($fp, $out);\n\n    // Read the response headers\n    $responseHeaders = [];\n    while (!feof($fp)) {\n        $responseHeaders[] = fgets($fp, 128);\n    }\n    fclose($fp);\n\n    // Extract HTTP status code from the first header line\n    $statusLine = $responseHeaders[0];\n    preg_match('/HTTP\/\d+\.\d+\s+(\d+)/', $statusLine, $matches);\n    return isset($matches[1]) ? (int)$matches[1] : null;\n}\n\n// Example usage:\n$url = "http://example.com";\n$statusCode = getHttpStatusCode($url);\necho "The HTTP status code for {$url} is: " . $statusCode;