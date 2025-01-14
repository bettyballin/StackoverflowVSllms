<?php\n\nclass Router {\n    private $routes = [];\n\n    public function get($path, $controller): void {\n        $this->registerRoute('GET', $path, $controller);\n    }\n\n    public function post($path, $controller): void {\n        $this->registerRoute('POST', $path, $controller);\n    }\n\n    // You can add more methods for PUT, DELETE etc.\n\n    private function registerRoute($method, $path, $controller): void {\n        $this->routes[$method][$path] = $controller;\n    }\n\n    public function dispatch() {\n        $requestMethod = $_SERVER['REQUEST_METHOD'];\n        $uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\n\n        if (isset($this->routes[$requestMethod][$uri])) {\n            call_user_func_array([$this->routes[$requestMethod][$uri][0], $this->routes[$requestMethod][$uri][1]], []);\n        } else {\n            // Handle 404 Not Found\n            header("HTTP/1.0 404 Not Found");\n            echo "Resource not found";\n        }\n    }\n}\n\n// Example usage:\n$router = new Router();\n$router->get('/users', [UserController::class, 'index']);\n$router->post('/users', [UserController::class, 'create']);\n\n$router->dispatch();