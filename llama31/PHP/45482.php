$dom = new DOMDocument();\n$dom->loadXML($yourXmlString);\n\n$fooElements = $dom->getElementsByTagName('foo');\nforeach ($fooElements as $fooElement) {\n    $barElement = $fooElement->getElementsByTagName('bar')->item(0);\n    $pubElement = $fooElement->getElementsByTagName('pub')->item(0);\n\n    if ($barElement !== null) {\n        $data['bar'] = $barElement->nodeValue;\n    }\n\n    if ($pubElement !== null) {\n        $data['pub'] = $pubElement->nodeValue;\n    }\n\n    // Do something with $data\n}