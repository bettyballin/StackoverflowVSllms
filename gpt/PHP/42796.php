<?php\n// URL of the Twitter Streaming API endpoint\n$url = "https://api.twitter.com/2/tweets/sample/stream";\n\n// Your Bearer Token for authentication\n$bearerToken = "YOUR_BEARER_TOKEN";\n\n// Initialize cURL session\n$ch = curl_init();\n\n// Set cURL options\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_TIMEOUT, 0); // No timeout for continuous streaming\ncurl_setopt($ch, CURLOPT_HTTPHEADER, [\n    "Authorization: Bearer $bearerToken",\n]);\n\n// Define a callback function to handle the streaming data\nfunction processStream($ch, $data) {\n    // Process the incoming data\n    echo $data;\n\n    // Return the number of bytes processed\n    return strlen($data);\n}\n\n// Set the cURL WRITEFUNCTION option to the callback function\ncurl_setopt($ch, CURLOPT_WRITEFUNCTION, 'processStream');\n\n// Execute the cURL session\ncurl_exec($ch);\n\n// Check for errors\nif(curl_errno($ch)) {\n    echo 'Error: ' . curl_error($ch);\n}\n\n// Close the cURL session\ncurl_close($ch);\n?>