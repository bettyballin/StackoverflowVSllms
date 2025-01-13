<?php\nrequire_once 'xmlrpc.inc';\n\n$xmlrpc_client = xmlrpc_client_create('http://example.com/xmlrpc_server.php');\n$xmlrpc_message = new xmlrpcmsg('add', array(2, 3));\n$xmlrpc_response = $xmlrpc_client->send($xmlrpc_message);\n\nif ($xmlrpc_response->faultCode() == 0) {\n  echo "Result: " . $xmlrpc_response->value() . "\n";\n} else {\n  echo "Error: " . $xmlrpc_response->faultString() . "\n";\n}\n?>