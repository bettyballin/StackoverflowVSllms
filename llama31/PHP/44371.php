// In your controller\n$object = new Object();\n$object->setName('Foo Bar');\n$viewData = new \Zend\View\Model\ViewModel(array(\n    'object' => $object,\n    'name' => $object->getName(),\n));\nreturn $viewData;