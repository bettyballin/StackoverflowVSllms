$submit = new Zend_Form_Element_Button('submit');\n$submit->setLabel('My Button');\n\n// Add the custom decorator\n$submit->addDecorator(new Custom_Decorator_SpanButtonLabel());\n\n// Standard decorators\n$submit->setDecorators(array(\n    'ViewHelper',\n    array('HtmlTag', array('tag' => 'li'))\n));\n$submit->setAttrib('type', 'submit');