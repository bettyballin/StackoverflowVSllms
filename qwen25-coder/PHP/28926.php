$s = new SimpleXMLElement('<root/>');\n$t = new SimpleXMLElement('<child/>');\n\n// Create 'a' child in $s\n$a = $s->addChild('a');\n\n// Convert $a and $t to DOMDocument\n$domA = dom_import_simplexml($a);\n$domT = dom_import_simplexml($t);\n\n// Import '$domT' into the document context of '$domA'\n$importedNode = $domA->ownerDocument->importNode($domT, true);\n\n// Append the imported node to '$domA'\n$domA->appendChild($importedNode);\n\necho $s->asXML();