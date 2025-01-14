<?php\n// Initialize cURL session\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "http://example.com");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\ncurl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);\n\n// Execute cURL session and get the content of the page\n$html = curl_exec($ch);\nif (curl_errno($ch)) {\n    echo 'Error:' . curl_error($ch);\n}\ncurl_close($ch);\n\n// Load the HTML content into DOMDocument\n$dom = new DOMDocument();\nlibxml_use_internal_errors(true); // Disable libxml errors for HTML5 compatibility\n$dom->loadHTML($html);\nlibxml_clear_errors();\n\n// Create a new XPath object\n$xpath = new DOMXPath($dom);\n\n// Query for elements with the class 'x'\n$elements = $xpath->query("//*[@class='x']");\n\n// Initialize an array to store the content\n$contentArray = [];\n\n// Loop through the elements and store the content\nforeach ($elements as $element) {\n    $contentArray[] = trim($element->textContent);\n}\n\n// Output the content as CSV\n$csvOutput = fopen('php://output', 'w');\nforeach ($contentArray as $line) {\n    fputcsv($csvOutput, [$line]);\n}\nfclose($csvOutput);\n\n// Output the content as XML\n$xml = new SimpleXMLElement('<root/>');\narray_walk_recursive($contentArray, function($value, $key) use ($xml){\n    $xml->addChild('item', $value);\n});\necho $xml->asXML();\n?>