function try_to_post($char_count) {\n    $url = 'http://gpx3quaa.joyent.us/test/recipient.php';\n    $post_data = str_repeat('x', $char_count);\n    $c = curl_init();\n    curl_setopt_array($c,\n        array(\n            CURLOPT_URL => $url,\n            CURLOPT_HEADER => false,\n            CURLOPT_CONNECTTIMEOUT => 999,\n            CURLOPT_RETURNTRANSFER => true,\n            CURLOPT_POST => 1,\n            CURLOPT_POSTFIELDS => $post_data,\n            CURLOPT_HTTPHEADER => array("Expect:") // Add this line\n        )\n    );\n    $result = curl_exec($c);\n    echo "{$result}\n";\n    curl_close($c);\n}