class Bootstrap extends Zend_Application_Bootstrap_Bootstrap\n   {\n       protected function _initBaseUrl()\n       {\n           $frontController = Zend_Controller_Front::getInstance();\n           $frontController->setBaseUrl('/subfolder');\n       }\n   }