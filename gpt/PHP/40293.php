// Using urlencode()\n$queryParam = "hello world";\n$url = "https://example.com/?search=" . urlencode($queryParam);\necho $url; // Outputs: https://example.com/?search=hello+world\n\n// Using rawurlencode()\n$path = "hello world";\n$url = "https://example.com/" . rawurlencode($path);\necho $url; // Outputs: https://example.com/hello%20world