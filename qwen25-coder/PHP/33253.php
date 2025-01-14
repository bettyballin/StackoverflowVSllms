trait CallableTrait {\n    public function __call($name, $arguments) {\n        // Check if the method actually exists in the class\n        if (method_exists($this, $name)) {\n            // Do something before calling the method\n            echo "Intercepted call to existing method '$name'.\n";\n            return call_user_func_array([$this, $name], $arguments);\n        }\n        \n        // Handle calls to non-existing methods\n        throw new BadMethodCallException("Method '$name' does not exist.");\n    }\n\n    public static function __callStatic($name, $arguments) {\n        // Check if the method actually exists in the class\n        if (method_exists(__CLASS__, $name)) {\n            // Do something before calling the static method\n            echo "Intercepted call to existing static method '$name'.\n";\n            return call_user_func_array([__CLASS__, $name], $arguments);\n        }\n\n        // Handle calls to non-existing methods\n        throw new BadMethodCallException("Static method '$name' does not exist.");\n    }\n}\n\nclass Example {\n    use CallableTrait;\n\n    public function publicMethod() {\n        echo "This is a public method.\n";\n    }\n\n    public static function staticPublicMethod() {\n        echo "This is a static public method.\n";\n    }\n}\n\n$example = new Example();\n$example->publicMethod(); // Outputs: Intercepted call to existing method 'publicMethod'.\nThis is a public method.\nExample::staticPublicMethod(); // Outputs: Intercepted call to existing static method 'staticPublicMethod'.\nThis is a static public method.