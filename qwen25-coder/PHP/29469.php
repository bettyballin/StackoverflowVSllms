use PHPUnit\Framework\TestCase;\n\nclass CalculatorTest extends TestCase {\n    public function testAddition() {\n        $calculator = new Calculator();\n        $result = $calculator->add(2, 3);\n        $this->assertEquals(5, $result);\n    }\n}\n\nclass Calculator {\n    public function add($a, $b) {\n        return $a + $b;\n    }\n}