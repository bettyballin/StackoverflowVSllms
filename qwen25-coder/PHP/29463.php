// Application/Bootstrap.php\n\nclass Bootstrap extends Zend_Application_Bootstrap_Bootstrap\n{\n    protected function _initAutoload()\n    {\n        $autoloader = new Zend_Application_Module_Autoloader(array(\n            'namespace' => '',\n            'basePath'  => APPLICATION_PATH,\n        ));\n\n        return $autoloader;\n    }\n\n    protected function _initFrontController()\n    {\n        $frontController = Zend_Controller_Front::getInstance();\n        $frontController->setModuleDirectory(APPLICATION_PATH . '/modules')\n                        ->setDefaultModule('default');\n\n        // Optionally, route definition\n        $router = $frontController->getRouter();\n        $router->addRoute(\n            'module',\n            ':module/:controller/:action/*',\n            array('controller' => 'index', 'action' => 'index')\n        );\n\n        return $frontController;\n    }\n}