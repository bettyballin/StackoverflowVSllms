class B extends A {\n    private $anotherA;\n\n    public function __construct(A $anotherA) {\n        $this->anotherA = $anotherA;\n    }\n}\n\n$anotherA = new A();\n$anotherA->myName = 'stackoverflow';\n$b = new B($anotherA);