<?php\nrequire_once 'xmlrpc.inc';\n\n$client = new xmlrpc_client('http://your-python-server.com/xmlrpc');\n\n// Make a call to the server\n$message = new xmlrpcmsg('your_method_name', array('param1', 'param2'));\n$response = $client->send($message);\n\n// Check the response\nif ($response->faultCode()) {\n    echo 'Error: ' . $response->faultString();\n} else {\n    echo 'Response: ' . $response->value();\n}\n?>