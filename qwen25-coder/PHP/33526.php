<?php\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "http://www.google.com");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n$output = curl_exec($ch);\nif(curl_errno($ch)) {\n    echo 'Curl error: ' . curl_error($ch);\n} else {\n    echo $output;\n}\ncurl_close($ch);\n?>