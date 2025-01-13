<?php\n$xmlString = <<<XML\n<root>\n    <element1 page="1">blah</element1>\n    <element2 page="1">blah blah</element2>\n    <element3 page="2">blah</element3>\n    <element4 page="3">blah blah</element4>\n</root>\nXML;\n\n$xml = new SimpleXMLElement($xmlString);\n$result = $xml->xpath('//*[contains(@page, "1")]');\n\n$assocArray = [];\nforeach ($result as $node) {\n    $assocArray[$node->getName()] = (string) $node;\n}\n\nprint_r($assocArray);\n?>