class MyClass {\n    public $value;\n\n    public function __construct($value) {\n        $this->value = $value;\n    }\n\n    public static function fromAnotherClass($another_class_obj) {\n        return new self($another_class_obj->value);\n    }\n}\n\nclass AnotherClass {\n    public $value;\n\n    public function __construct($value) {\n        $this->value = $value;\n    }\n}\n\n$another_class_obj = new AnotherClass('example');\n$obj = MyClass::fromAnotherClass($another_class_obj);\n\nvar_dump($obj);