<?php\n\n// Data to be sent in POST request\n$data = array(\n    'key1' => 'value1',\n    'key2' => 'value2'\n);\n\n// URL of the API endpoint\n$url = "https://example.com/api";\n\n// Initialize cURL session\n$ch = curl_init();\n\n// Set the URL\ncurl_setopt($ch, CURLOPT_URL, $url);\n\n// Return the transfer as a string instead of outputting it directly\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n// Tell cURL that we want to send a POST request\ncurl_setopt($ch, CURLOPT_POST, 1);\n\n// Attach our encoded JSON string to the POST fields\ncurl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));\n\n// Make sure you are verifying SSL certificates and not bypassing them\n// If you need this for testing purposes only and have no certificate:\n// curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);\n// But NEVER use the above in production\n\n// Execute the request and assign the response to a variable\n$response = curl_exec($ch);\n\n// Check for errors\nif(curl_errno($ch)) {\n    echo 'Curl error: ' . curl_error($ch);\n}\n\n// Close the cURL session\ncurl_close($ch);\n\n// Output the response\necho $response;\n\n?>