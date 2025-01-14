spl_autoload_register(function ($class) {\n    $file = __DIR__ . '/' . $class . '.php';\n    if (file_exists($file)) {\n        require_once $file;\n    }\n});\n\nabstract class Auto\n{\n    // ... some stuff ...\n\n    public static function Create($type)\n    {\n        switch ($type) {\n            case 'Truck':\n                return new Truck();\n                break;\n            case 'Car':\n            default:\n                return new Car();\n                break;\n        }\n    }\n}\n\n// Usage\n$car = Auto::Create('Car');\n$truck = Auto::Create('Truck');