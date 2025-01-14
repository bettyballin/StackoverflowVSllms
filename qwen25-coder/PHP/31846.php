// Define your namespaces based on the functionality of the class\nnamespace MyProject\ORM;\n\nclass ORM {\n    // Your ORM implementation here\n}\n\nclass QueryBuilder {\n    // Implementation for query builder\n}\n\n// ...\n\n// Implementing autoloader in a separate bootstrap file or at the top of your script\nspl_autoload_register(function ($class) {\n    $prefix = 'MyProject\\ORM\\';\n    $base_dir = __DIR__ . '/src/'; // Assuming all classes are under src/\n\n    $len = strlen($prefix);\n    if (strncmp($prefix, $class, $len) !== 0) {\n        return;\n    }\n\n    $relative_class = substr($class, $len);\n    $file = $base_dir . str_replace('\\', '/', $relative_class) . '.php';\n\n    if (file_exists($file)) {\n        require_once $file;\n    }\n});\n\n// Example usage\n$record = new MyProject\ORM\ORM();