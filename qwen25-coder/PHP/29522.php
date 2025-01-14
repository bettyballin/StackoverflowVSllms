// Set up front controller\n$frontController = Zend_Controller_Front::getInstance();\n\n// Create a request object with the correct base URL\n$request = new Zend_Controller_Request_Http();\n$request->setBaseUrl('/quickstart'); // Adjust to your subfolder\n\n// Assign the request object to the front controller\n$frontController->setRequest($request);\n\n// Continue with dispatching\n$frontController->dispatch();