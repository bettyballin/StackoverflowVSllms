<?php\n$proxy = "http://your-proxy-server:port";\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "http://example.com");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_PROXY, $proxy);\ncurl_setopt($ch, CURLOPT_PROXYUSERPWD, "username:password"); // If your proxy requires authentication\n$response = curl_exec($ch);\ncurl_close($ch);\necho $response;\n?>