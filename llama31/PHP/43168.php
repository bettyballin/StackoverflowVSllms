class MyClass {\n    private $myOtherClass;\n\n    public function __construct(MyOtherClass $myOtherClass) {\n        $this->myOtherClass = $myOtherClass;\n    }\n\n    public function myMethod() {\n        $this->myOtherClass->myOtherMethod($this);\n        // ...\n    }\n}\n\nclass MyOtherClass {\n    public function myOtherMethod(MyClass $param) {\n        // ...\n    }\n}