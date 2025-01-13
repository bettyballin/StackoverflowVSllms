// Set an ad URL\n$adUrl = 'http://example.com/ad-banner.jpg';\n\n// Use curl to check if the ad is loaded\n$ch = curl_init($adUrl);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_HEADER, true);\ncurl_setopt($ch, CURLOPT_NOBODY, true);\n$response = curl_exec($ch);\ncurl_close($ch);\n\n// Check if the ad is loaded\nif ($response === false || strpos($response, 'HTTP/1.1 404 Not Found') !== false) {\n  // AdBlocker detected\n  echo 'AdBlocker detected';\n}