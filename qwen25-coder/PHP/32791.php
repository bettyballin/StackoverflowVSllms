$xml_text = file_get_contents("php://input");\n$xml = simplexml_load_string($xml_text);\n$lowercase_xml = new SimpleXMLElement($xml_text);\n$lowercase_xml_copy = $lowercase_xml->asXML();\n$lowercase_simplexml = simplexml_load_string(strtolower($lowercase_xml_copy));\necho $lowercase_simplexml->item;