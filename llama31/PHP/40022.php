class MyPlugin extends Zend_Controller_Plugin_Abstract\n{\n    public function preDispatch(Zend_Controller_Request_Abstract $request)\n    {\n        $uri = $_SERVER['REQUEST_URI'];\n        // parse the URI and extract the controller and action\n        // ...\n        $request->setControllerName($controller);\n        $request->setActionName($action);\n    }\n}