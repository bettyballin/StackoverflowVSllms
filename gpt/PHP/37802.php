use PHPUnit\Framework\TestCase;\n\nclass MyTest extends TestCase\n{\n    public function testEquality()\n    {\n        $text = "blah";\n        $this->assertEquals("blah", $text);\n    }\n}