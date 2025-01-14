<?php\nheader('Content-Type: text/html;charset=UTF-8');\n\n// Set internal encoding to UTF-8 in case your environment uses a different one\nmb_internal_encoding("UTF-8");\n\n$xml = simplexml_load_file('yourfile.xml', 'SimpleXMLElement', LIBXML_NOCDATA);\n\nif ($xml === false) {\n    foreach(libxml_get_errors() as $error) {\n        echo "\n", $error->message;\n    }\n} else {\n    // Assume the XML contains a tag <price> with the pound sign\n    $price = (string)$xml->price;\n    \n    // Echo the price to be used in AJAX response\n    echo htmlspecialchars($price, ENT_QUOTES, 'UTF-8');\n}\n?>