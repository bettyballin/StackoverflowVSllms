<?php\n// create a new cURL resource\n$ch = curl_init();\n\n// set URL and other appropriate options\ncurl_setopt($ch, CURLOPT_URL, "http://www.example.com/");\ncurl_setopt($ch, CURLOPT_HEADER, 1);\ncurl_setopt($ch, CURLOPT_NOBODY, 1);\n\n// grab URL and pass it to the browser\ncurl_exec($ch);\n\n// close cURL resource, and free up system resources\ncurl_close($ch);\n?>