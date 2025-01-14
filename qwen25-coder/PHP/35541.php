function parseXML($xmlContent) {\n    $dom = new DOMDocument();\n    \n    // Suppress error display and capture warnings in an array\n    libxml_use_internal_errors(true);\n    $loaded = $dom->loadXML($xmlContent);\n    $errors = libxml_get_errors();\n    libxml_clear_errors();\n\n    if (!$loaded || !empty($errors)) {\n        // Handle errors\n        $errorMessage = '';\n        foreach ($errors as $error) {\n            $errorMessage .= "Error {$error->code} - Line {$error->line}, Column {$error->column}: {$error->message}\n";\n        }\n        return ['dom' => null, 'error' => $errorMessage];\n    }\n\n    // Return the DOMDocument object for further processing\n    return ['dom' => $dom, 'error' => null];\n}\n\n// Example usage:\n$xmlContent = '<root><child>Value</child></root>'; // Replace with actual XML content\n$result = parseXML($xmlContent);\n\nif ($result['error']) {\n    echo "Parse error:\n" . $result['error'];\n} else {\n    $dom = $result['dom'];\n    // Perform further checks using XPath or other DOM methods\n    $xpath = new DOMXPath($dom);\n    $nodes = $xpath->query('//child');\n   foreach ($nodes as $node) {\n        echo "Node value: " . $node->nodeValue . "\n";\n    }\n}