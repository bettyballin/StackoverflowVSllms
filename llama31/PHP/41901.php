require_once 'Zend/Amf/Server.php';\nrequire_once 'Zend/Amf/Request.php';\n\n$server = new Zend_Amf_Server();\n$server->addDirectory('./services');\n$response = $server->handle();\necho $response;