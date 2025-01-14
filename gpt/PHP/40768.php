<?php\n// Initialize a cURL session\n$ch = curl_init();\n\n// Set the URL and other options\ncurl_setopt($ch, CURLOPT_URL, "http://example.com/api");\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// Execute the cURL request and get the response\n$response = curl_exec($ch);\n\n// Check for errors\nif(curl_errno($ch)) {\n    echo 'cURL Error: ' . curl_error($ch);\n} else {\n    // Parse the XML response into an object\n    $xmlObject = simplexml_load_string($response);\n\n    // Convert the XML object to JSON and then to an associative array\n    $json = json_encode($xmlObject);\n    $array = json_decode($json, true);\n\n    // Print the array\n    print_r($array);\n}\n\n// Close the cURL session\ncurl_close($ch);\n?>