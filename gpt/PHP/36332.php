function myFunction($arg1, $arg2, $arg3) {\n    echo "Argument 1: $arg1\n";\n    echo "Argument 2: $arg2\n";\n    echo "Argument 3: $arg3\n";\n}\n\n$args = ['value1', 'value2', 'value3'];\n\nmyFunction(...$args);