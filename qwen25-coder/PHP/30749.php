<?php\n\n$url = 'http://example.com/yourfile.xml';\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n$xmlContent = curl_exec($ch);\n\nif(curl_errno($ch)) {\n    echo 'Curl error: ' . curl_error($ch);\n} else {\n    $xml = simplexml_load_string($xmlContent);\n    \n    if ($xml === false) {\n        foreach(libxml_get_errors() as $error) {\n            echo "\n", $error->message;\n        }\n    } else {\n        // Process your XML here\n        print_r($xml);\n    }\n}\n\ncurl_close($ch);\n\n?>