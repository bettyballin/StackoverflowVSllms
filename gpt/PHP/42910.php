spl_autoload_register(function ($class_name) {\n       include 'classes/' . $class_name . '.php';\n   });