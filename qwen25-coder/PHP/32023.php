function updateXMLByType($filePath, $type, $data = null) {\n    // Load the XML file into a DOMDocument object\n    $xmlDoc = new DOMDocument();\n    $xmlDoc->load($filePath);\n\n    // Search for all marker elements with the specified type\n    $xpath = new DOMXPath($xmlDoc);\n    $markersToRemove = $xpath->query("//marker[type='$type']");\n\n    // Remove the found markers\n    foreach ($markersToRemove as $marker) {\n        $marker->parentNode->removeChild($marker);\n    }\n\n    // If data is provided, add it to the XML\n    if ($data && is_array($data)) {\n        foreach ($data as $item) {\n            $newMarker = $xmlDoc->createElement("marker");\n\n            $typeElement = $xmlDoc->createElement("type", $type);\n            $titleElement = $xmlDoc->createElement("title", $item['title']);\n            $addressElement = $xmlDoc->createElement("address", $item['address']);\n            $latitudeElement = $xmlDoc->createElement("latitude", $item['latitude']);\n            $longitudeElement = $xmlDoc->createElement("longitude", $item['longitude']);\n\n            $newMarker->appendChild($typeElement);\n            $newMarker->appendChild($titleElement);\n            $newMarker->appendChild($addressElement);\n            $newMarker->appendChild($latitudeElement);\n            $newMarker->appendChild($longitudeElement);\n\n            $xmlDoc->documentElement->appendChild($newMarker);\n        }\n    }\n\n    // Save the changes back to the file\n    $xmlDoc->save($filePath);\n}\n\n// Example usage:\n$dataForHotels = [\n    ['title' => 'Hotel A', 'address' => '123 Main St', 'latitude' => '40.7128', 'longitude' => '-74.0060'],\n    ['title' => 'Hotel B', 'address' => '456 Elm St', 'latitude' => '40.7306', 'longitude' => '-73.9352']\n];\n\nupdateXMLByType('markers.xml', 'hotels', $dataForHotels);\n\n// To remove hotels and add schools\n$dataForSchools = [\n    ['title' => 'School A', 'address' => '789 Oak St', 'latitude' => '40.6610', 'longitude' => '-73.9442']\n];\n\nupdateXMLByType('markers.xml', 'schools', $dataForSchools);