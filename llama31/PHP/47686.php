class My_View_Helper_Login extends Zend_View_Helper_Abstract\n{\n    public function login()\n    {\n        $loginForm = new My_Form_Login();\n        return $loginForm->render();\n    }\n}