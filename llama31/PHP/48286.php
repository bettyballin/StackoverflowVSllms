$ch = curl_init('http://rss.fok.nl/feeds/nieuws');\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_TIMEOUT, 5); // set a 5-second timeout\n$response = curl_exec($ch);\ncurl_close($ch);