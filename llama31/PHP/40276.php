$allowedHosts = ['localhost', 'example.com'];\n$redirectUrl = 'http://localhost/';\n$parsedUrl = parse_url($redirectUrl);\nif (!in_array($parsedUrl['host'], $allowedHosts)) {\n    // handle invalid redirect URL\n}