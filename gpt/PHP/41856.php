<?php\n// Include the XML-RPC library\ninclude("xmlrpc.inc");\n\n// Create the XML-RPC client\n$client = new xmlrpc_client("/RPC2", "www.example.com", 80);\n\n// Create the message to be sent\n$message = new xmlrpcmsg("sample.method", array(\n    new xmlrpcval("param1", "string"),\n    new xmlrpcval(123, "int")\n));\n\n// Send the request\n$response = $client->send($message);\n\n// Check for errors\nif (!$response->faultCode()) {\n    // Get the value from the response\n    $value = $response->value();\n    echo "Response: " . $value->scalarval();\n} else {\n    echo "Error: " . $response->faultString();\n}\n?>