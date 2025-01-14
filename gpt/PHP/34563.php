<?php\n// Include the NuSOAP library\nrequire_once('path/to/nusoap.php');\n\n// Create a new client instance\n$client = new soapclient('http://example.com/service?wsdl', true);\n\n// Check for any errors in the WSDL\n$err = $client->getError();\nif ($err) {\n    echo '<h2>Constructor error</h2><pre>' . $err . '</pre>';\n}\n\n// Call the SOAP method\n$result = $client->call('YourSOAPMethod', array('param1' => 'value1', 'param2' => 'value2'));\n\n// Check for a fault\nif ($client->fault) {\n    echo '<h2>Fault</h2><pre>';\n    print_r($result);\n    echo '</pre>';\n} else {\n    // Check for errors\n    $err = $client->getError();\n    if ($err) {\n        echo '<h2>Error</h2><pre>' . $err . '</pre>';\n    } else {\n        // Display the result\n        echo '<h2>Result</h2><pre>';\n        print_r($result);\n        echo '</pre>';\n    }\n}\n?>