<?php\n\nfunction findNodesWithClass($xmlString, $className) {\n    // Load the XML string into a SimpleXMLElement object\n    $xml = simplexml_load_string($xmlString);\n\n    if (!$xml) {\n        throw new Exception("Failed to load XML");\n    }\n\n    // Use XPath to find all nodes with the specified class name\n    // The '//' indicates that we want to search through the entire document recursively\n    $xpathQuery = "//*[@class=\"$className\"]";\n    $nodes = $xml->xpath($xpathQuery);\n\n    return $nodes;\n}\n\n// Example usage:\n$xhtmlContent = '<body><div class="example">Text 1</div><p class="example">Text 2</p><span>Text 3</span></body>';\n$className = "example";\n$matchingNodes = findNodesWithClass($xhtmlContent, $className);\n\nforeach ($matchingNodes as $node) {\n    echo $node->getName() . ": " . (string)$node . "\n";\n}\n\n?>