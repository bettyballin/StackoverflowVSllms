<?php\n$qu = isset($_GET["qu"]) ? $_GET["qu"] : '';\n$url = "http://www.google.com/complete/search?hl=en&js=true&q=" . urlencode($qu);\n\n// Initialize a cURL session\n$ch = curl_init();\n\n// Set the URL and other options\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_USERAGENT, 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3');\n\n// Execute the request and get the response\n$response = curl_exec($ch);\n\nif(curl_errno($ch)) {\n    echo 'cURL error: ' . curl_error($ch);\n} else {\n    echo $response;\n}\n\n// Close cURL session\ncurl_close($ch);\n?>