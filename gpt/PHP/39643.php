<?php\n$url = 'http://www.something.com/myOwnScript.php';\n\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_USERAGENT, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3');\n$data = curl_exec($ch);\n\nif ($data === FALSE) {\n    die('Error: "' . curl_error($ch) . '" - Code: ' . curl_errno($ch));\n}\n\ncurl_close($ch);\n\n// Process the XML data\n$xml = simplexml_load_string($data);\nif ($xml === FALSE) {\n    die('Error parsing XML.');\n}\n\n// Your XML manipulation logic here\n?>