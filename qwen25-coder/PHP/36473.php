$t = new Zend_Form_Element_Select('mySelect');\n$t->setLabel('My Select Label');\n\n// Remove all default decorators and only use ViewHelper decorator for rendering the select box\n$t->setDecorators(array(\n    'ViewHelper'\n));\n\necho $t->render();