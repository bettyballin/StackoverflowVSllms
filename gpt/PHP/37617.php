$document = new DOMDocument();\n$document->loadHTML($htmlContent); // Load your HTML content\n\n$xpath = new DOMXPath($document);\n$textNodes = $xpath->query('//text()');\n\n$nodes = [];\nforeach ($textNodes as $node) {\n    $nodes[] = $node;\n}\n\n// $nodes now contains all text nodes in the document