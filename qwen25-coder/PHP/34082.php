$filters = array(\n    '*' => 'StringTrim'\n);\n\n$validators = array(\n    'email' => 'EmailAddress',\n    'age'   => array('Int', new Zend_Validate_Between(18, 99))\n);\n\n$input = new Zend_Filter_Input($filters, $validators, $_POST);