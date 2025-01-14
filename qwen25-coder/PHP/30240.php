<?php\n\n$url = 'http://example.com/path/to/your/rest/service';\n\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// If you need to send data (POST request)\n$data = array('key1' => 'value1', 'key2' => 'value2');\ncurl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));\n\n$result = curl_exec($ch);\n\nif(curl_errno($ch)) {\n    echo 'Request Error:' . curl_error($ch);\n} else {\n    print_r(json_decode($result, true)); // Assuming the response is JSON\n}\n\ncurl_close($ch);\n\n?>