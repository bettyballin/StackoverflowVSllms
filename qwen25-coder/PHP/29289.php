$doc = simplexml_load_string($xmlString); // Load your XML string into a SimpleXML object\n\nforeach ($doc->seg as $index => $seg) {\n    if ((string)$seg['id'] === 'A12') { // Ensure attribute is cast to a string for comparison\n        unset($doc->seg[$index]); // Unset the node at this index in the parent\n        break; // Exit loop once element is found and removed\n    }\n}