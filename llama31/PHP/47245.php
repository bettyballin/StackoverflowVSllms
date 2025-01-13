class ClassA {\n    public function call() {\n        return $this->inner();\n    }\n\n    protected function inner() {\n        return "Class A";\n    }\n}\n\nclass ClassB extends ClassA {\n    protected function inner() {\n        return "Class B";\n    }\n}\n\n$a = new ClassA();\n$b = new ClassB();\n\necho "<p>Class A = " . $a->call();\necho "<p>Class B = " . $b->call();