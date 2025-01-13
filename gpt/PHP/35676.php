class My_Form_DateExample extends Zend_Form\n{\n    public function init()\n    {\n        $this->addElement('text', 'dateField', array(\n            'label' => 'Date (dd/mm/yyyy):',\n            'required' => true,\n            'validators' => array(\n                new My_Validate_DateFormat(),\n            ),\n            'filters' => array(\n                new My_Filter_DateToDb(),\n            ),\n        ));\n    }\n}