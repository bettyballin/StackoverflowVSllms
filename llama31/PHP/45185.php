$client = new Zend_Rest_Client('http://localhost/my_application/api/index/');\n$client->getHttpClient()->setAdapter('Zend_Http_Client_Adapter_Curl');\n$client->auth($key);\n$result = $client->get();