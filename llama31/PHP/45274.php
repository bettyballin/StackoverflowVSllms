$wsdl = 'http://example.com/service?wsdl';\n$client = new SoapClient($wsdl);\n$result = $client->SomeMethod($args);