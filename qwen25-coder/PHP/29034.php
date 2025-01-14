<?php\n\nfunction isWellFormedXml($url) {\n    // Suppress the internal error reporting to handle malformed XML gracefully\n    libxml_use_internal_errors(true);\n\n    // Fetch remote content\n    $xmlData = file_get_contents($url);\n    \n    if ($xmlData === FALSE) {\n        // Handle error fetching data from URL\n        return false;\n    }\n\n    // Attempt to load the XML string into a SimpleXMLElement object\n    $dom = new DOMDocument();\n    $loaded = @$dom->loadXML($xmlData);\n\n    // Clear any errors that may have been raised by libxml\n    libxml_clear_errors();\n\n    // If loading was successful and no errors were raised, consider it well-formed XML\n    return $loaded === true;\n}\n\n$url = "http://remote.com/client.asp";\nif (isWellFormedXml($url)) {\n    echo "The remote file is a well-formed XML.\n";\n} else {\n    echo "The remote file is not well-formed XML or there was an error fetching the content.\n";\n}\n?>