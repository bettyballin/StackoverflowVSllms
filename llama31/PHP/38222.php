$html = '<p>Hello <span>World</span>!</p>';\n$xml = simplexml_load_string($html);\n$nodes = $xml->xpath('//*');\nforeach ($nodes as $node) {\n    echo $node->getName() . "\n";\n}