<?php\n\nfunction callApi($url) {\n    $ch = curl_init();\n\n    // Set the URL for the request\n    curl_setopt($ch, CURLOPT_URL, $url);\n\n    // Specify the return type to be a string\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n\n    // Set a timeout (in seconds)\n    curl_setopt($ch, CURLOPT_TIMEOUT, 5); // Timeout after 5 seconds\n\n    // Execute the cURL request and get the response\n    $response = curl_exec($ch);\n\n    // Check for errors\n    if (curl_errno($ch)) {\n        $error_msg = curl_error($ch);\n        // Handle error or log it\n        echo 'Error: ' . $error_msg;\n        return false;\n    }\n\n    // Close the cURL resource\n    curl_close($ch);\n\n    return $response;\n}\n\n// Example usage\n$url = "https://api.twitter.com/1.1/statuses/user_timeline.json";\n$response = callApi($url);\nif ($response !== false) {\n    // Process your response here\n    echo "Response: " . $response;\n} else {\n    // Handle the API being down or not responding\n    echo "Failed to fetch data from API.";\n}\n\n?>