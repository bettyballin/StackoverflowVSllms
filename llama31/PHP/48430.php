class Mojo_Bootstrap extends Zend_Application_Module_Bootstrap\n{\n    protected function _initLayout()\n    {\n        // set layout for mojo module\n        $layout = new Zend_Layout();\n        $layout->setLayout('mojo-layout');\n        Zend_Layout::registerLayout($layout);\n    }\n\n    // other mojo-specific bootstrapping code here\n}