// Example of API usage in OpenCart\n   $curl = curl_init('http://example.com/index.php?route=api/login');\n   curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\n   $response = curl_exec($curl);\n   curl_close($curl);