$dom = new DOMDocument();\n// Load your XML or create your document\n$dom->loadXML('<foo>Blah blah <bar baz="1">bah</bar> blah blah</foo>');\n\n// Get the 'foo' node\n$node = $dom->documentElement;\n\n// Get the inner XML of the node\n$xmlContent = $dom->saveXML($node);\n\necho htmlspecialchars($xmlContent);