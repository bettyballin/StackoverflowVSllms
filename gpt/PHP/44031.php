class ExampleForm extends Core_Form\n{\n    public function init()\n    {\n        // Example Field\n        $example = new Zend_Form_Element_Hidden('example');\n        // Disable all decorators for this field\n        $example->setDecorators(array('ViewHelper'));\n        $this->addElement($example);\n    }\n}