$router = $frontController->getRouter();\n   \n   // Define the hostname route\n   $route = new Zend_Controller_Router_Route_Hostname(\n       ':username.mywebapp.com',\n       array(\n           'controller' => 'user',\n           'action' => 'profile'\n       )\n   );\n\n   // Add the route to the router\n   $router->addRoute('user', $route);