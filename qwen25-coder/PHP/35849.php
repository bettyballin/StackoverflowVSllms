$ip = '192.168.1.5'; // Change this to your desired IP address\n$url = 'http://example.com/api';\n\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_INTERFACE, $ip); // Bind to the specific IP\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n$response = curl_exec($ch);\nif (curl_errno($ch)) {\n    echo 'Curl error: ' . curl_error($ch);\n} else {\n    echo $response;\n}\n\ncurl_close($ch);