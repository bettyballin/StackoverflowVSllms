spl_autoload_register(function ($class) {\n    if (strpos($class, 'Zend_') === 0) {\n        require_once 'Zend/' . str_replace('_', '/', $class) . '.php';\n    }\n});