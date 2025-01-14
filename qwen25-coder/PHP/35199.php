require_once('nusoap.php'); // Include the Nusoap library\n\n$soapclient = new soapclient('https://adwords.google.com/api/adwords/v201809', true); // WSDL URL\n\n// Define your parameters, if any\n$params = array(\n    'param1' => 'value1',\n    'param2' => 'value2'\n);\n\n// Call the SOAP function\n$result = $soapclient->call('FunctionName', $params);\n\nif ($err = $soapclient->getError()) {\n    echo '<h2>Constructor error</h2><pre>' . $err . '</pre>';\n} else {\n    echo '<h2>Call Result:</h2><p>';\n    print_r($result);\n}\n\n// Check for a fault\nif ($fault = $soapclient->fault) {\n    echo '<h2>Fault (SOAP call error)</h2><pre>';\n    print_r($fault);\n    echo '</pre>';\n}