<?php\n$data = '<data><item>Value</item></data>';\n$url = 'http://example.com/receiver.php';\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_POST, true);\ncurl_setopt($ch, CURLOPT_POSTFIELDS, $data);\ncurl_setopt($ch, CURLOPT_HTTPHEADER, array(\n    'Content-Type: application/xml',\n    'Content-Length: ' . strlen($data)\n));\n\n$response = curl_exec($ch);\nif ($response === false) {\n    die('Error: "' . curl_error($ch) . '" - Code: ' . curl_errno($ch));\n}\ncurl_close($ch);\n\necho "Response: " . $response;\n?>