$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, 'https://example.com/xmlfile');\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n$xml = curl_exec($ch);\ncurl_close($ch);