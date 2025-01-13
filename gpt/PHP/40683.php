$options = [\n        'trace' => true,\n        'exceptions' => true,\n    ];\n\n    try {\n        $client = new SoapClient('https://path.to/your.wsdl', $options);\n        // Make a call to the SOAP service to see the request and response\n        $response = $client->SomeFunction();\n        echo "Request :\n" . $client->__getLastRequest() . "\n";\n        echo "Response:\n" . $client->__getLastResponse() . "\n";\n    } catch (SoapFault $fault) {\n        echo "Error: " . $fault->getMessage();\n    }