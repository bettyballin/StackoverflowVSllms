<?php\n// Set the URL to the XML file\n$url = 'http://example.com/yourfile.xml';\n\n// Initialize a cURL session\n$ch = curl_init();\n\n// Set the cURL options\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// Execute the cURL session and fetch the XML content\n$xml_content = curl_exec($ch);\n\n// Close the cURL session\ncurl_close($ch);\n\nif ($xml_content !== false) {\n    // Load the XML content into a SimpleXMLElement\n    $xml = simplexml_load_string($xml_content);\n\n    if ($xml !== false) {\n        // Successfully loaded the XML, you can now work with it\n        print_r($xml);\n    } else {\n        echo 'Failed to load XML content';\n    }\n} else {\n    echo 'Failed to fetch XML content from URL';\n}\n?>