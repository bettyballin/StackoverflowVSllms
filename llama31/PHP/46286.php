$xmlString = '';\nforeach ($node->childNodes as $child) {\n    $xmlString .= $doc->saveXML($child);\n}\necho $xmlString;