$client = new SoapClient('http://yourwebservice.com/service.asmx?wsdl', array(\n       'trace' => 1,\n       'soap_version' => SOAP_1_2 // or SOAP_1_1 if required by your web service\n   ));