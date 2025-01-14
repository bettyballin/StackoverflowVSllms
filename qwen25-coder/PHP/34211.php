// Let's assume this code is placed in Bootstrap.php\nclass Bootstrap extends Zend_Application_Bootstrap_Bootstrap {\n\n    protected function _initAcl()\n    {\n        $acl = new Zend_Acl();\n\n        // Add roles\n        $acl->addRole(new Zend_Acl_Role('normal'))\n            ->addRole(new Zend_Acl_Role('admin'), 'normal');\n\n        // Define resources as per your controllers/actions\n        $resources = [\n            'index',  // index controller\n            'about',\n            'account',\n            'admin',  // admin controller\n            'settings'\n        ];\n\n        foreach ($resources as $resource) {\n            $acl->addResource(new Zend_Acl_Resource($resource));\n        }\n\n        /* Define permissions */\n        // Normal users can access all non-admin resources\n        // Admins can access everything\n\n        foreach ($resources as $resource) {\n            if ($resource !== 'admin') {\n                $acl->allow('normal', $resource);\n            }\n            $acl->allow('admin', $resource);\n        }\n\n        // Store the ACL in the registry\n        Zend_Registry::set('ACL', $acl);\n\n        return $acl;\n    }\n\n    protected function _initFrontController()\n    {\n        $front = Zend_Controller_Front::getInstance();\n        $front->registerPlugin(new App_Plugin_Acl());\n        return $front;\n    }\n}