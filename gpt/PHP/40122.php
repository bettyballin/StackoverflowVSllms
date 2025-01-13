<?php\n// Create a new DOMDocument instance\n$doc = new DOMDocument();\n\n// Load HTML or XML content into the document\n$doc->loadHTML('<html><body><div><p>Example</p></div></body></html>');\n\n// Get the elements by tag name\n$nodes = $doc->getElementsByTagName('div');\n\n// Check if the node is a DOMElement and use it accordingly\nforeach ($nodes as $node) {\n    if ($node instanceof DOMElement) {\n        // Now, $node is treated as DOMElement\n        $childNodes = $node->getElementsByTagName('p');\n        foreach ($childNodes as $childNode) {\n            echo $childNode->nodeValue;  // Outputs: Example\n        }\n    }\n}\n?>