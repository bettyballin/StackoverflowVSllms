<?php\n$url = "https://stackoverflow.com/questions/ask";\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n$htmlContent = curl_exec($ch);\n\nif(curl_errno($ch)) {\n    die('Curl error: ' . curl_error($ch));\n}\n\ncurl_close($ch);\n\necho $htmlContent;\n?>