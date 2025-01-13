<?php\n// index.php\n\nrequire 'vendor/autoload.php';\n\nuse App\Core\Router;\nuse App\Core\Request;\n\n$router = new Router();\n$request = Request::capture();\n\n// Define your routes\n$router->get('/', function() {\n    return 'Welcome to the homepage!';\n});\n\n$router->post('/submit', function() {\n    // Handle form submission\n    return 'Form submitted!';\n});\n\n// Dispatch the request\n$router->dispatch($request);