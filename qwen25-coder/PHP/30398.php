$form = new Zend_Form();\n\n// Adding first text element with array notation\n$element1 = new Zend_Form_Element_Text('element[1]');\n$element1->setLabel('Element 1:');\n$form->addElement($element1);\n\n// Adding second text element with array notation\n$element2 = new Zend_Form_Element_Text('element[2]');\n$element2->setLabel('Element 2:');\n$form->addElement($element2);\n\n// And so on for other elements...