$obj = new MyClass();\n$method = 'myMethod';\n$args = array('arg1', 'arg2');\n\n// Using call_user_func()\ncall_user_func(array($obj, $method), $args[0], $args[1]);\n\n// Using call_user_func_array()\ncall_user_func_array(array($obj, $method), $args);