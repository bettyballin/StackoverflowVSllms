\n$doc = new DOMDocument();\nforeach($node->childNodes as $child) {\n    $doc->appendChild($doc->importNode($child, true));\n}\nreturn $doc->saveHTML();