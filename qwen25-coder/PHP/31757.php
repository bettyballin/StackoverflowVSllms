<?php\n\n$url = "https://www.example.com/link/sublink";\n$username = 'username';\n$password = 'password';\n\n// Initiate cURL session\n$ch = curl_init();\n\n// Set cURL options\ncurl_setopt($ch, CURLOPT_URL, $url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true); // Return content as a string\ncurl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC); // Use basic authentication\ncurl_setopt($ch, CURLOPT_USERPWD, "$username:$password"); // Set username and password\n\n// Optional: If you need to verify the server's SSL certificate\ncurl_setopt($ch, CURLOPT_SSL_VERIFYPEER, true);\ncurl_setopt($ch, CURLOPT_CAINFO, '/path/to/cacert.pem'); // Path to your CA bundle or specific cert file\n\n// Execute cURL session and store the response\n$response = curl_exec($ch);\n\n// Check for cURL errors\nif (curl_errno($ch)) {\n    echo 'cURL Error: ' . curl_error($ch);\n} else {\n    echo $response; // Output the XML data\n}\n\n// Close cURL session\ncurl_close($ch);\n\n?>