$html = '<p>Hello <span>World</span>!</p>';\n$doc = new DOMDocument();\n$doc->loadHTML($html);\n$nodes = $doc->getElementsByTagName('*');\nforeach ($nodes as $node) {\n    echo $node->nodeName . "\n";\n}