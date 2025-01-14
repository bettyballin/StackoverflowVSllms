<?php\nrequire_once('lib/nusoap.php');\n\n$client = new nusoap_client('http://localhost:3333/Service.asmx?wsdl', 'wsdl');\n$client->soap_defencoding = 'UTF-8';\n$client->decode_utf8 = false;\n\n// Define the complex type 'Param' for parameters array\n$parametersArray = array(\n    new soapval('Param', 'tns:Param',\n        new soapval('paramItem1', 'Param',\n            array(\n                new soapval('Value', 'string', 'Scott'),\n                new soapval('Name', 'string', 'firstName')\n            )\n        )\n    ),\n    new soapval('Param', 'tns:Param',\n        new soapval('paramItem2', 'Param',\n            array(\n                new soapval('Value', 'string', 'Smith'),\n                new soapval('Name', 'string', 'lastName')\n            )\n        )\n    )\n);\n\n// Create the parameters for the DoSomething method\n$params = new soapval('DoSomething', 'tns:DoSomething',\n    array(\n        new soapval('anId', 'int', 3),\n        new soapval('action', 'string', 'OMNOMNOMNOM'),\n        $parametersArray\n    )\n);\n\n// Call the web service method\n$result = $client->call('DoSomething', $params, '', 'http://tempuri.org/webservices/DoSomething');\n\nif ($err = $client->getError()) {\n    echo '<h2>Constructor error</h2><pre>' . $err . '</pre>';\n} else {\n    print_r($result);\n}\n?>