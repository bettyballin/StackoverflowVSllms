$client = new SoapClient($wsdlPath, array(\n    'login' => $username,\n    'password' => $password,\n    'location' => $apiPath,\n    'trace' => 1,\n));