<?php    \nfunction get_url($url)\n{\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_HEADER, 0);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    curl_setopt($ch, CURLOPT_URL, $url);\n    $data = curl_exec($ch);\n    curl_close($ch);\n\n    return $data;\n}\n\n$xml_content = get_url("http://www.e24.se/?service=rss&type=latest");\n\n$dom = new DOMDocument();\n@$dom->loadXML($xml_content);\n$xpath = new DomXPath($dom);\n$results = $xpath->query('//channel//title/text()');\n\nforeach ($results as $result) \n{\n    echo $result->nodeValue . "<br />";\n}\n?>