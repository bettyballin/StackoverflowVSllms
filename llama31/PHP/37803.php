$dom = new DOMDocument();\n$dom->loadXML($xml_string);\n$array = $dom->toArray();