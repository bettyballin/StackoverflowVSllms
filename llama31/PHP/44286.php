// application/plugins/AclPlugin.php\n\nclass Application_Plugin_Acl extends Zend_Controller_Plugin_Abstract\n{\n    public function preDispatch(Zend_Controller_Request_Abstract $request)\n    {\n        $acl = new Application_Config_Acl();\n        $role = 'normal'; // default role\n\n        // Load role from session or database\n        // ...\n\n        $controller = $request->getControllerName();\n        $action = $request->getActionName();\n\n        if (!$acl->isAllowed($role, $controller)) {\n            throw new Zend_Controller_Exception('Access denied', 403);\n        }\n    }\n}