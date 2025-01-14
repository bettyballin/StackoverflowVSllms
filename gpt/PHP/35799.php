require_once 'lib/xmlrpc.inc';\n    $client = new xmlrpc_client('/RPC2', 'xmlrpc.example.com', 80);\n    $message = new xmlrpcmsg('sample.method', array(new xmlrpcval("parameter")));\n    $response = $client->send($message);\n    \n    if ($response->faultCode()) {\n        echo "Error: " . $response->faultString();\n    } else {\n        echo "Response: " . $response->value()->scalarval();\n    }