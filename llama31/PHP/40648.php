function myprint(...$args) {\n    echo implode(' ', $args);\n}\n\nmyprint('Hello', 'World');  // requires parentheses