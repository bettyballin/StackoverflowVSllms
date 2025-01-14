function prettyPrintHTML(DOMDocument $doc) {\n    $dom = new DOMDocument('1.0');\n    $dom->preserveWhiteSpace = false;\n    $dom->formatOutput = true;\n\n    // Import nodes from the original document to this new one.\n    $node = $dom->importNode($doc->documentElement, true);\n    $dom->appendChild($node);\n\n    return $dom->saveHTML();\n}\n\n// Usage\n$originalDOMDocument = new DOMDocument;\nlibxml_use_internal_errors(true); // Suppress errors for malformed HTML if needed\n$originalDOMDocument->loadHTML(mb_convert_encoding($htmlString, 'HTML-ENTITIES', 'UTF-8'));\nlibxml_clear_errors();\n\necho prettyPrintHTML($originalDOMDocument);