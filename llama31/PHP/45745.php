$url = 'https://example.com';\n\n$headers = get_headers($url, 1);\n\nif ($headers[0] === 'HTTP/1.1 404 Not Found') {\n    echo "URL returns 404";\n} else {\n    echo "URL is valid";\n}