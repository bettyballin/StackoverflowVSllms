class AppController extends Controller\n{\n    var $components = array('Auth');\n\n    function beforeFilter()\n    {\n        $this->Auth->loginAction = array('controller' => 'users', 'action' => 'login');\n        $this->Auth->loginRedirect = array('controller' => 'pages', 'action' => 'home');\n        $this->Auth->logoutRedirect = '/';\n        $this->Auth->authorize = 'controller';\n        $this->Auth->userScope = array('User.active' => 1);\n    }\n\n    function isAuthorized()\n    {\n        return true; // Default allow\n    }\n}\n\nclass SomeController extends AppController\n{\n    function isAuthorized()\n    {\n        if (strpos($this->action, "admin_") !== false)\n        {\n            if ($this->Auth->user('isAdmin') == '0')\n            {\n                return false;\n            }\n        }\n        return true;\n    }\n}