$form = new Form_Job();\n$form->setDecorators(Decorator::$formDecorators);\n$form->setElementDecorators(Decorator::$elementDecorators);\n$form->getElement('submit')->setDecorators(Decorator::$buttonDecorators);