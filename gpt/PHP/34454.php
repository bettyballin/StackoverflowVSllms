<?php\n// Initialize the SoapClient\n$client = new SoapClient("http://example.com/your_wsdl.wsdl");\n\n// Create the request array\n$request = array(\n    'GetResultListRequest' => array(\n        'Filters' => array(\n            'Filter' => array(\n                array(\n                    'Name' => 'string',\n                    'Value' => 'string'\n                ),\n                array(\n                    'Name' => 'string',\n                    'Value' => 'string'\n                )\n            )\n        )\n    )\n);\n\ntry {\n    // Call the SOAP function\n    $response = $client->__soapCall("GetResultList", array($request));\n    \n    // Handle the response\n    print_r($response);\n} catch (SoapFault $fault) {\n    // Handle the error\n    echo "Error: " . $fault->getMessage();\n}\n?>