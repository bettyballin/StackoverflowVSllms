<?php\n$url = 'http://www.test.com/foo.xml';\n\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_FAILONERROR, 1);\n\n$xmlContent = curl_exec($ch);\n\nif ($xmlContent === FALSE) {\n    echo 'cURL error: ' . curl_error($ch);\n} else {\n    echo $xmlContent;\n}\n\ncurl_close($ch);\n?>