function sendFireAndForget($url) {\n    $ch = curl_init();\n    \n    // Set the URL\n    curl_setopt($ch, CURLOPT_URL, $url);\n    \n    // Set timeout to 0 (no wait)\n    curl_setopt($ch, CURLOPT_TIMEOUT_MS, 1);\n    \n    // Exec and close immediately after sending request headers\n    curl_exec($ch);\n    curl_close($ch);\n}\n\n// Example usage:\nsendFireAndForget("http://example.com/trigger_event.php");