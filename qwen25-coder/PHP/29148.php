class ExampleForm extends Core_Form\n{\n    public function init()\n    {\n        // Example Field\n        $example = new Zend_Form_Element_Hidden('example');\n        \n        // Clear decorators for this element\n        $example->setDecorators(array());\n\n        $this->addElement($example);\n    }\n}