$allowedClasses = [\n    'MyClass1' => ['method1', 'method2'],\n    'MyClass2' => ['method3', 'method4'],\n];\n\n$class = filter_var($_GET['class'], FILTER_SANITIZE_STRING);\n$method = filter_var($_GET['method'], FILTER_SANITIZE_STRING);\n\nif (!isset($allowedClasses[$class]) || !in_array($method, $allowedClasses[$class])) {\n    throw new Exception('Invalid class or method');\n}\n\n$obj = (new ReflectionClass($class))->newInstance();\nif (!$obj instanceof $class) {\n    throw new Exception('Invalid class instantiation');\n}\n\nif (!method_exists($obj, $method)) {\n    throw new Exception('Method not found');\n}\n\necho $obj->$method();