// router.php\nfunction route($uri) {\n    $routes = [\n        '/' => 'HomeController@index',\n        '/about' => 'AboutController@index',\n        '/contact' => 'ContactController@index',\n    ];\n\n    return isset($routes[$uri]) ? $routes[$uri] : 'ErrorController@notFound';\n}\n\n// index.php\n$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\n$controllerAction = route($uri);\nlist($controller, $action) = explode('@', $controllerAction);\n\n// Autoload classes\nspl_autoload_register(function ($class_name) {\n    include $class_name . '.php';\n});\n\n$controllerInstance = new $controller();\n$controllerInstance->$action();