class MyClass {\n    private $data = array();\n\n    public function __set($name, $value) {\n        $this->data[$name] = $value;\n    }\n\n    public function __get($name) {\n        return isset($this->data[$name]) ? $this->data[$name] : null;\n    }\n}\n\n$obj = new MyClass();\n$obj->newMember = "I was added dynamically!";\n\necho $obj->newMember; // Outputs: I was added dynamically!