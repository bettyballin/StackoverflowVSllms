// Set API endpoint and parameters\n$apiEndpoint = 'http://www.zillow.com/webservice/GetZestimate.htm';\n$address = $_POST['street'];\n$cityStateZip = $_POST['citystatezip'];\n$zwsId = 'YOUR_ZWSID_HERE'; // Replace with your ZWS ID\n\n// Construct API request URL\n$requestUrl = $apiEndpoint . '?zws-id=' . $zwsId . '&citystatezip=' . $cityStateZip . '&address=' . $address;\n\n// Initialize curl session\n$curl = curl_init($requestUrl);\n\n// Set curl options\ncurl_setopt($curl, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($curl, CURLOPT_HEADER, 0);\n\n// Execute curl request\n$response = curl_exec($curl);\n\n// Close curl session\ncurl_close($curl);\n\n// Parse XML response\n$xml = simplexml_load_string($response);\n\n// Extract Zestimate data\n$zestimate = $xml->response->zestimate;\n\n// Display Zestimate data\necho 'Zestimate: ' . $zestimate->amount . '<br>';\necho 'Last Updated: ' . $zestimate->lastUpdated;