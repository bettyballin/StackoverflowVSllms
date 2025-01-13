$element = new Zend_Form_Element_Text('exampleElement');\n$element->setLabel('Example Element')\n        ->setRequired(true)\n        ->addValidator('NotEmpty', true, array('messages' => array(\n            Zend_Validate_NotEmpty::IS_EMPTY => 'This field cannot be left blank.'\n        )));\n\n// Add the element to the form\n$form = new Zend_Form();\n$form->addElement($element);