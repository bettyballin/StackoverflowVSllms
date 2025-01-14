<?php\n// Load the HTML document\n$doc = new DOMDocument();\nlibxml_use_internal_errors(true);\n$doc->loadHTMLFile('your_file.html');\nlibxml_clear_errors();\n\n// Create an XPath object\n$xpath = new DOMXPath($doc);\n\n// Query the document\n$elements = $xpath->query('//div[@class="example-class"]');\n\nforeach ($elements as $element) {\n    echo $element->nodeValue . "\n";\n}\n?>