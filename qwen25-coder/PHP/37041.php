class Router {\n    private $request;\n    const SUBDOMAIN_TO_CONTROLLER = [\n        'kodi' => 'UserStore',\n        'admin' => 'AdminPanel',\n    ];\n    \n    public function __construct(DPLS_Request $request) {\n        $this->request = $request;\n    }\n    \n    public function routeRequest() {\n        // Determine the controller based on subdomain\n        if (isset(self::SUBDOMAIN_TO_CONTROLLER[$this->request->_segment])) {\n            $controllerName = self::SUBDOMAIN_TO_CONTROLLER[$this->request->_segment];\n        } else {\n            $controllerName = 'Default';\n        }\n        \n        $actionName = isset($this->request->_request['action']) ? $this->request->_request['action'] : 'index';\n        \n        $controllerClassName = ucfirst($controllerName) . 'Controller';\n        if (class_exists($controllerClassName)) {\n            $controller = new $controllerClassName();\n            if (method_exists($controller, $actionName)) {\n                call_user_func_array([$controller, $actionName], []);\n            } else {\n                // Action not found in the controller\n            }\n        } else {\n            // Controller not defined for the subdomain or action\n        }\n    }\n}