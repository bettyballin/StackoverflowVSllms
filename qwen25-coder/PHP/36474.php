function foo() {\n    $args = func_get_args();\n    foreach ($args as $index => $arg) {\n        doSomethingWith($arg, $index + 1);\n    }\n}