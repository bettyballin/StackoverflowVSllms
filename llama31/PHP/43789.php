php > spl_autoload_register(function ($class) {\n    include 'path/to/your/classes/' . $class . '.php';\n});\nphp > $obj = new YourClass();