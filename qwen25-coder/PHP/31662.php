$email = new Zend_Form_Element_Text('email');\n    $email->setRequired(true)\n          ->setLabel('Email')\n          ->addValidator(new Zend_Validate_EmailAddress(), true, ['messages' => [\n              'emailAddressInvalidFormat' => 'Please enter a valid email address.',\n              'emailAddressNotFound'      => "The provided email address doesn't exist.",\n          ]]);