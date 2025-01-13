<?php\n\n$curl = curl_init('http://www.example.com');\n\n//make content be returned by curl_exec rather than being printed immediately                                 \ncurl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\n\n$result = curl_exec($curl);\n\nif ($result !== false) {\n    if (preg_match('|<title>(.*)</title>|i', $result, $matches)) {\n        echo "Title is '{$matches[1]}'";   \n    } else {\n        //did not find the title    \n    }\n} else {\n    //request failed\n    die (curl_error($curl)); \n}