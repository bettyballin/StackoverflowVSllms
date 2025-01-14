$ch = curl_init();\n   \n   // Set the URL and other options\n   curl_setopt($ch, CURLOPT_URL, "http://your-solr-server/solr/update");\n   curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n   curl_setopt($ch, CURLOPT_HTTPHEADER, array(\n       'Connection: keep-alive',\n       'Keep-Alive: timeout=5, max=1000'\n   ));\n   curl_setopt($ch, CURLOPT_HTTP_VERSION, CURL_HTTP_VERSION_1_1);\n\n   // Send your request\n   $response = curl_exec($ch);\n\n   // Check for errors\n   if (curl_errno($ch)) {\n       echo 'Curl error: ' . curl_error($ch);\n   }\n\n   // Close the handle (but you can reuse it for keep-alive)\n   curl_close($ch);