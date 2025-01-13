// Create an instance of Zend_Auth\n$auth = Zend_Auth::getInstance();\n\n// Create an instance of your adapter\n$adapter = new My_Auth_Adapter($username, $password);\n\n// Perform the authentication\n$result = $auth->authenticate($adapter);\n\nif ($result->isValid()) {\n    // Authentication successful\n    $identity = $result->getIdentity();\n    // Store identity, etc.\n} else {\n    // Authentication failed\n    $messages = $result->getMessages();\n    // Handle error messages\n}