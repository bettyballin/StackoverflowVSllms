spl_autoload_register(function ($class_name) {\n    include 'inc/' . $class_name . '.class.php';\n});