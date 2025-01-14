class MyOtherObject {\n    // Example class definition\n}\n\nclass Object {\n    public function __construct(MyOtherObject $object) {\n        // do something with $object\n    }\n}\n\nrequire_once 'simpletest/autorun.php';\n\nclass TestOfObject extends UnitTestCase {\n    public function testConstruct_ExpectsAnInstanceOfMyOtherObject() {\n        $notAnObject = 'foobar';\n        $this->expectException('TypeError');\n        $object = new Object($notAnObject);\n    }\n}