// Create an instance of your form element\n   $element = new Zend_Form_Element_Text('my_element');\n   \n   // Set the label, required, and remove default validators if necessary\n   $element->setLabel('My Field')\n           ->setRequired(true)\n           ->addValidator(new My_Validate_NotEmpty());\n   \n   // If you added the 'NotEmpty' validator by default, you can clear other validators\n   $element->clearValidators();\n   \n   // Alternatively, just add your custom one after clearing all others if needed