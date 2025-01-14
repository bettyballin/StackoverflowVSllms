<?php\n// Function to generate XML for the chart\nfunction generateChartXML($data) {\n    $xml = new SimpleXMLElement('<chart></chart>');\n    \n    foreach ($data as $key => $value) {\n        $set = $xml->addChild('set');\n        $set->addAttribute('name', $key);\n        $set->addAttribute('value', $value);\n    }\n\n    return $xml->asXML();\n}\n\n// Example data\n$data = array(\n    'January' => 10,\n    'February' => 20,\n    'March' => 30\n);\n\n// Generate the XML\n$chartXML = generateChartXML($data);\n\n// Output the XML\nheader('Content-type: text/xml');\necho $chartXML;\n?>