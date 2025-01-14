$xml_results = '<?xml version="1.0" encoding="UTF-8"?><Properties><Property><Name>Joes Crab Shack</Name><Address>111 Shack Street</Address></Property><Property><Name>Johns Shoe Store</Name><Address>123 Shoe Avenue</Address></Property></Properties>';\n\n// Load the XML data into a SimpleXMLElement object\n$xml = simplexml_load_string($xml_results);\n\n// Check if the XML was successfully loaded\nif ($xml === false) {\n    echo "Failed loading XML\n";\n} else {\n    // Loop through each Property element in the XML\n    foreach ($xml->Property as $property) {\n        // Output the Name of the property\n        echo 'Name: ', htmlspecialchars(trim($property->Name)), "\n";\n    }\n}