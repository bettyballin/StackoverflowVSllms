// application/default/Bootstrap.php\nclass Default_Bootstrap extends Zend_Application_Module_Bootstrap\n{\n    protected function _initLayout()\n    {\n        $this->bootstrap('layout');\n        $layout = Zend_Layout::getMvcInstance();\n        $layout->setLayoutPath(APPLICATION_PATH . '/default/views/layouts');\n    }\n}\n\n// application/admin/Bootstrap.php\nclass Admin_Bootstrap extends Zend_Application_Module_Bootstrap\n{\n    protected function _initLayout()\n    {\n        $this->bootstrap('layout');\n        $layout = Zend_Layout::getMvcInstance();\n        $layout->setLayoutPath(APPLICATION_PATH . '/admin/views/layouts');\n    }\n}