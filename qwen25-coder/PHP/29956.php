// application/forms/SampleForm.php\nclass Application_Form_SampleForm extends Zend_Form {\n    public function init() {\n        $this->setMethod('post');\n\n        $element = new Zend_Form_Element_Text('username');\n        $element->setLabel('Username')\n                ->addValidator('NotEmpty', true, array('messages' => 'Please enter your username'))\n                ->setRequired(true);\n        $this->addElement($element);\n\n        $element = new Zend_Form_Element_Password('password');\n        $element->setLabel('Password')\n                ->addValidator('NotEmpty', true, array('messages' => 'Please enter a password'))\n                ->setRequired(true);\n        $this->addElement($element);\n\n        $submit = new Zend_Form_Element_Submit('Submit');\n        $this->addElement($submit);\n    }\n}