// Start buffering\n  ob_start();\n  \n  // Send initial HTML content and necessary headers\n  echo "<html><head>...</head><body>Loading...<div id='content'>";\n  ob_flush();\n\n  // Perform external API call and process response\n  $data = fetchDataFromAPI($url);\n  echo '<pre>' . json_encode($data, JSON_PRETTY_PRINT) . '</pre>';\n\n  // Close the buffer and send final content\n  echo "</body></html>";\n  ob_end_flush();