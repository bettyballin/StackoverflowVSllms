class ServiceResponse {\n    public $outgoingVar1;\n}\n\n$response = new stdClass();\n$response->ServiceResponse = new ServiceResponse();\n$response->ServiceResponse->outgoingVar1 = true;\n\n// Set the correct namespace in the server configuration\n$server = new SoapServer("your_wsdl_file.wsdl", array('uri' => 'http://sample.com'));\n$server->addFunction("serviceMessage");\n$server->handle();