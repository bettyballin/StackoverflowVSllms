$wsdlPath = "";    // Set this to your WSDL URL\n$apiPath = "";     // Optional: If using a different host for SOAP calls\n$username = "";\n$password = "";\n\ntry {\n    // Initialize the SoapClient\n    $options = array(\n        'login' => $username,      // Corrected typo: 'username'\n        'password' => $password,\n        'soap_version' => SOAP_1_2,\n        'location' => $apiPath,    // Optional: Override WSDL endpoint (if needed)\n        'trace' => 1                 // Enable tracing for debugging\n    );\n    \n    $client = new SoapClient($wsdlPath, $options);\n\n    // Example call to a SOAP function (adjust method name and parameters as needed)\n    $result = $client->SomeSoapFunction(array('param1' => 'value1'));\n    echo "Response: ";\n    print_r($result);\n    \n} catch (SoapFault $e) {\n    if ($client instanceof SoapClient && property_exists($client, '__getLastRequest')) {\n        // Print the last SOAP request and response for debugging\n        echo __FILE__ . ':' . __LINE__ . "\n" . '<pre>' \n            . 'Request Headers: ' . htmlspecialchars($client->__getLastRequestHeaders(), ENT_QUOTES | ENT_HTML5)\n            . '</pre>'\n            . '<pre>'\n            . 'Request: ' . htmlspecialchars($client->__getLastRequest(), ENT_QUOTES | ENT_HTML5)\n            . '</pre>'\n            . '<pre>' \n            . 'Response Headers: ' . htmlspecialchars($client->__getLastResponseHeaders(), ENT_QUOTES | ENT_HTML5) \n            . '</pre>'\n            . '<pre>'\n            . 'Response: ' . htmlspecialchars($client->__getLastResponse(), ENT_QUOTES | ENT_HTML5)\n            . '</pre>';\n    }\n    \n    // Output error message\n    echo "EXCEPTION=" . $e->getMessage() . "\n";\n}