$route = new Zend_Controller_Router_Route_Static(\n    'register', \n    array(\n        'module'     => 'members',\n        'controller' => 'Members_Register', // note the namespace prefix\n        'action'     => 'index'\n    )\n);