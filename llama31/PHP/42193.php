$ch = curl_init();\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_TIMEOUT, 20); // set timeout for entire request\ncurl_setopt($ch, CURLOPT_CONNECTTIMEOUT, 10); // set timeout for initial connection\ncurl_setopt($ch, CURLOPT_USERAGENT, $_SERVER['HTTP_USER_AGENT']);\ncurl_setopt($ch, CURLOPT_FOLLOWLOCATION, false); // don't follow redirects\ncurl_setopt($ch, CURLOPT_HEADER, true); // header will be at output\ncurl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'HEAD'); // HTTP request is 'HEAD'\n\n$content = curl_exec($ch);\ncurl_close($ch);