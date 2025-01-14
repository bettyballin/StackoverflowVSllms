class MyClass {\n    public function myMethod($param) {\n        echo "Called with parameter: " . $param;\n    }\n}\n\n$obj = new MyClass();\n$methodName = 'myMethod';\n$parameter = 'Hello, World!';\n\n// Using call_user_func\ncall_user_func([$obj, $methodName], $parameter);\n\n// Alternatively, using call_user_func_array\ncall_user_func_array([$obj, $methodName], [$parameter]);