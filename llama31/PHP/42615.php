$url = 'https://stackoverflow.com/questions/ask';\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$html = curl_exec($ch);\ncurl_close($ch);