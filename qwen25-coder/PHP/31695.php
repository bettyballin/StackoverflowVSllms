// In your controller or form setup\n  $form = new Zend_Form();\n  $form->setDecorators([\n      ['ViewScript', ['viewScript' => 'forms/myCustomLayout.phtml']]\n  ]);\n\n  // Add elements as usual