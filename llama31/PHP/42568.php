<?php\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "http://example.com");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n$output = curl_exec($ch);\ncurl_close($ch);\nprint($output);\n?>