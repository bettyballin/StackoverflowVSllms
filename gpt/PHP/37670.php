$doc = new DOMDocument();\n$doc->loadXML($xml);\n\n$xpath = new DOMXPath($doc);\n$query = "normalize-space(./@media)";\n\n$elements = $xpath->query($query);\n\nforeach ($elements as $element) {\n    echo $element->nodeValue;\n}