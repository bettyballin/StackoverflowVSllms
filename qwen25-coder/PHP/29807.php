$params = array(\n    new SoapParam($someDataForClient, "client"), // Replace $someDataForClient with actual data\n    new SoapParam($add_code, "add_code")\n);\n$result = $client->__call($functionName, $params);