$filters = [\n    '*' => 'StringTrim',  // Trim all input values\n];\n\n$validators = [\n    'email' => 'EmailAddress',  // Validate email format\n];\n\n$input = new Zend_Filter_Input($filters, $validators, $_POST);\n\nif ($input->isValid()) {\n    // Process the valid input\n} else {\n    // Handle invalid input\n}