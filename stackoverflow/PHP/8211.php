public function testConstruct_ExpectsAnInstanceOfMyOtherObject() {\n    $notAnObject = 'foobar';\n    $this->expectError(new PatternExpectation("/must be an instance of/i"));\n    $object = new Object($notAnObject);\n}