use PHPUnit\Framework\TestCase;\n\nclass ExampleTest extends TestCase\n{\n    public function testAddition()\n    {\n        $this->assertEquals(4, 2 + 2);\n    }\n}