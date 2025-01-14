// Create a new select form element\n$element = new Zend_Form_Element_Select('score');\n$element->setLabel('Score:')\n        ->addMultiOptions(array(\n            -3 => '-3',\n            -2 => '-2',\n            -1 => '-1',\n             0 => ' 0',\n             1 => ' 1',\n             2 => ' 2',\n             3 => ' 3'\n        ))\n        // Adding Zend_Validate_Between validator\n        ->addValidator('Between', false, array(-3, 3, true))\n        // Set custom messages for validation errors\n        ->setMessages(array(\n            Zend_Validate_Between::NOT_BETWEEN_STRICT => "Your score must be strictly between -3 and 3.",\n            Zend_Validate_InArray::NOT_IN_ARRAY => "Please select a valid option from the list."\n        ));\n\n// Create a form and add the element\n$form = new Zend_Form();\n$form->addElements(array($element));