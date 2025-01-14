<?php\n\nclass Router {\n    private $routes = [];\n\n    public function addRoute($method, $path, $callback) {\n        $this->routes[] = [\n            'method' => $method,\n            'path' => $path,\n            'callback' => $callback\n        ];\n    }\n\n    public function dispatch($method, $path) {\n        foreach ($this->routes as $route) {\n            if ($route['method'] === $method && preg_match($this->convertToRegex($route['path']), $path, $matches)) {\n                array_shift($matches); // Remove the full match\n                return call_user_func_array($route['callback'], $matches);\n            }\n        }\n        // Handle 404\n        http_response_code(404);\n        echo "404 Not Found";\n    }\n\n    private function convertToRegex($path) {\n        return '@^' . preg_replace('/{([a-zA-Z0-9_]+)}/', '(?P<$1>[^/]+)', $path) . '$@';\n    }\n}\n\n// Usage example:\n\n$router = new Router();\n\n// Define routes\n$router->addRoute('GET', '/users', function() {\n    echo "List of users";\n});\n\n$router->addRoute('GET', '/users/{id}', function($id) {\n    echo "User ID: " . htmlspecialchars($id);\n});\n\n$router->addRoute('POST', '/users', function() {\n    echo "Create a new user";\n});\n\n// Dispatch based on current request\n$method = $_SERVER['REQUEST_METHOD'];\n$path = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);\n$router->dispatch($method, $path);