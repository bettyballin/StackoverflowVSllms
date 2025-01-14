class Printer {\n    public function __call($name, $arguments) {\n        if ($name === 'myprint') {\n            echo implode('', $arguments);\n        }\n    }\n\n    static public function myprint(...$args) {\n        echo implode('', $args);\n    }\n}\n\n// Usage as a method\n$p = new Printer();\n$p->myprint('Hello', ' ', 'World', "\n");\n\n// Static usage (you still need parentheses)\nPrinter::myprint('Hello', ' ', 'World', "\n");