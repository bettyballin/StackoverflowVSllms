function isWellFormedXML($url) {\n    // Fetch the content from the URL\n    $content = file_get_contents($url);\n    \n    if ($content === FALSE) {\n        return false; // Failed to retrieve content\n    }\n    \n    // Suppress errors and try to parse the XML\n    libxml_use_internal_errors(true);\n    $xml = simplexml_load_string($content);\n    \n    if ($xml === FALSE) {\n        // Handle errors\n        foreach(libxml_get_errors() as $error) {\n            // Log or handle the error as needed\n            // For example: error_log($error->message);\n        }\n        // Clear the error buffer\n        libxml_clear_errors();\n        return false; // Not well-formed XML\n    }\n    \n    return true; // Well-formed XML\n}\n\n// Example usage\n$url = 'http://remote.com/client.asp';\nif (isWellFormedXML($url)) {\n    echo "The feed is well-formed XML.";\n} else {\n    echo "The feed is not well-formed XML.";\n}