$ch = curl_init();\n   curl_setopt($ch, CURLOPT_URL,$API_Endpoint);\n   curl_setopt($ch, CURLOPT_VERBOSE, 1);\n\n   // Turn off the server and peer verification (TrustManager Concept).\n   curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, FALSE);\n   curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, FALSE);\n\n   curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n   curl_setopt($ch, CURLOPT_POST, 1);\n   \n   // Set the request as a POST FIELD for Curl.\n   curl_setopt($ch, CURLOPT_POSTFIELDS, $nvpreqstring);\n   \n   $response = curl_exec($ch);\n   curl_close ($ch);