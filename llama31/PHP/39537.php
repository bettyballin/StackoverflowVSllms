function autoload($class) {\n    $file = APP_ROOT . '/classes/' . $class . '.php';\n    if (file_exists($file)) {\n        include $file;\n    }\n}\n\nspl_autoload_register('autoload');