$element = new Zend_Form_Element_Text('name');\n$element->setErrorMessages(array(\n    'isEmpty' => 'Please enter your name'\n));\n$form->addElement($element);