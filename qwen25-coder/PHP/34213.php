class App_Plugin_Acl extends Zend_Controller_Plugin_Abstract\n{\n    protected $_acl;\n    protected $_auth;\n\n    public function __construct()\n    {\n        // Get ACL from registry\n        $this->_acl = Zend_Registry::get('ACL');\n\n        // Assume Auth setup done and store identity role in session if it's not there yet\n        $sessionNamespace = new Zend_Session_Namespace('userRole');\n        if (!isset($sessionNamespace->role)) {\n            // Get auth instance, check identity exists otherwise set to 'normal'\n            $auth = Zend_Auth::getInstance();\n            if ($auth->hasIdentity()) {\n                $identity = $auth->getIdentity();\n                $sessionNamespace->role = $identity->role;\n            } else {\n                $sessionNamespace->role = 'normal';\n            }\n        }\n\n        $this->_auth = $sessionNamespace->role;\n    }\n\n    public function preDispatch(Zend_Controller_Request_Abstract $request)\n    {\n        // Get the action controller name as resource and action (usually in lowercase)\n        $resource = strtolower($request->getControllerName());\n        $action = strtolower($request->getActionName());\n\n        if (!$this->_acl->isAllowed($this->_auth, $resource, $action)) {\n            // Redirect to denied page, or error controller\n            $request->setModuleName('default')\n                    ->setControllerName('error')\n                    ->setActionName('accessdenied');\n\n            return;\n        }\n    }\n}