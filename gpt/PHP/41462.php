// Using associative arrays\n$anArray = array('foo', 'bar', 2);\n$anObjectLikeAssociativeArray = array('foo' => 'bla', 'bar' => 2);\n\n// Using a class to create an object\nclass MyObject {\n    public $foo;\n    public $bar;\n\n    public function __construct($foo, $bar) {\n        $this->foo = $foo;\n        $this->bar = $bar;\n    }\n}\n\n$anObject = new MyObject('bla', 2);\n\necho $anObject->foo; // Output: bla\necho $anObject->bar; // Output: 2