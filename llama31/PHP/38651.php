$response = $client->__getLastResponse();\n$response = iconv('ISO-8859-1', 'UTF-8', $response);\n$xml = simplexml_load_string($response);