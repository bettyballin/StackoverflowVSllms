spl_autoload_register(function ($class) {\n       $file = __DIR__ . '/' . str_replace('\\', '/', $class) . '.php';\n       if (file_exists($file)) {\n           include_once $file;\n       }\n   });\n\n   class Foo {\n       function doFoo() {\n           // Use functionalities from classes automatically loaded\n       }\n   }