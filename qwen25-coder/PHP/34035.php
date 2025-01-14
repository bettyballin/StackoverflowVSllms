function removeGetVariables($url) {\n    $parsedUrl = parse_url($url);\n    return $parsedUrl['scheme'] . '://' . $parsedUrl['host'] . (isset($parsedUrl['port']) ? ':' . $parsedUrl['port'] : '') . $parsedUrl['path'];\n}\n\n$current_url = "https://example.com/page.php?foo=bar&baz=qux";\necho removeGetVariables($current_url); // Outputs: https://example.com/page.php