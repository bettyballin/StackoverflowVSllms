class MyClass {\n    private $person = array();\n\n    public function setPerson($key, $value) {\n        $this->person[$key] = $value;\n    }\n\n    public function getPerson($key) {\n        return $this->person[$key];\n    }\n}\n\n$obj = new MyClass();\n$obj->setPerson('name', 'perro');