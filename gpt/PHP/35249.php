$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, 'https://example.com/data.json');\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$response = curl_exec($ch);\ncurl_close($ch);\n$json = json_decode($response, true);