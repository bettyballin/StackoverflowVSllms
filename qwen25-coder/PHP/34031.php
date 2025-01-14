use Zend_Controller_Front;\nuse Zend_Controller_Router_Route;\n\n$frontController = Zend_Controller_Front::getInstance();\n$router = $frontController->getRouter();\n\n// Route for login.php\n$loginRoute = new Zend_Controller_Router_Route(\n    'login.php',\n    array('controller' => 'legacy', 'action' => 'login')\n);\n$router->addRoute('custom-login', $loginRoute);\n\n// Route for show.php\n$showRoute = new Zend_Controller_Router_Route(\n    'show.php',\n    array('controller' => 'legacy', 'action' => 'show')\n);\n$router->addRoute('custom-show', $showRoute);