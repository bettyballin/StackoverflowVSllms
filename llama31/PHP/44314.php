$route = new Zend_Controller_Router_Route_Regex(\n    'my/method/(\w+)/(\w+)/(\w+)',\n    array('controller' => 'my', 'action' => 'method'),\n    array('paramA', 'paramB', 'paramC')\n);\n$router->addRoute('myRoute', $route);