$ch = curl_init('http://somewebsite.com');\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$html = curl_exec($ch);\ncurl_close($ch);\n\necho $html;