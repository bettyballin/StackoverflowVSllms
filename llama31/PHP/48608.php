protected function _initRequest()\n{\n    $this->bootstrap('FrontController');\n    $frontController = $this->getResource('FrontController');\n    $request = new Zend_Controller_Request_Http();\n    $request->setBaseUrl('/'); // set the base URL to the root of the domain\n    $frontController->setRequest($request);\n}