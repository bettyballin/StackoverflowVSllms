$text = 'John Doe was born on... <img src="/jd.jpg" alt="John Doe at the beach" />';\n\n$dom = new DOMDocument();\nlibxml_use_internal_errors(true); // Suppress errors due to malformed HTML\n$dom->loadHTML($text);\nlibxml_clear_errors();\n\n// Walk through all text nodes and replace "John Doe"\nforeach ($dom->createTreeWalker($dom, XMLFilter_LIBXML::FILTER_ACCEPT) as $node) {\n    if ($node instanceof DOMText && strpos($node->nodeValue, 'John Doe') !== false) {\n        $node->nodeValue = str_replace('John Doe', 'Jane Smith', $node->nodeValue);\n    }\n}\n\necho $dom->saveHTML();