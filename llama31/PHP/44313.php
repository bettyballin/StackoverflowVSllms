// In your Bootstrap.php or in your module configuration\n$router = $this->getApplication()->getRouter();\n$route = new Zend_Controller_Router_Route(\n    'default',\n    array(),\n    array(),\n    new Zend_Controller_Router_Route_Module(\n        array(),\n        array(),\n        array(),\n        'Default'\n    )\n);\n$router->addRoute('default', $route);\n\n// In your controller\nclass MyController extends Zend_Controller_Action\n{\n    public function methodAction($paramA, $paramB, $paramC)\n    {\n        // ... code\n    }\n}