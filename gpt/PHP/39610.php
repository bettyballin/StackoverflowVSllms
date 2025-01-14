class Foo\n{\n    public $bar;\n\n    public function TestFoobar()\n    {\n        $this->foobar('bar');\n    }\n\n    public function foobar($string)\n    {\n        echo $this->{$string}; // Correct way to reference the property dynamically\n    }\n}\n\n// Example usage\n$foo = new Foo();\n$foo->bar = "Hello, World!";\n$foo->TestFoobar(); // Outputs: Hello, World!