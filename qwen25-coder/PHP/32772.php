<?php\n$data = [\n    'key1' => 'value1',\n    'key2' => 'value2',\n    'key3' => ['subkey1' => 'subvalue1', 'subkey2' => 'subvalue2']\n];\n\n$ch = curl_init('http://example.com/api');\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_POST, 1);\ncurl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));\n\n$response = curl_exec($ch);\ncurl_close($ch);\n\necho $response;\n?>