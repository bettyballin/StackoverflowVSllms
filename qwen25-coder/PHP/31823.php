<?php\n// tests/AddTest.php\n\nuse PHPUnit\Framework\TestCase;\n\nclass AddTest extends TestCase {\n    public function testAdd() {\n        include_once __DIR__ . '/../procedural_code.php'; // Adjust the path as necessary\n        \n        $this->assertEquals(5, add(2, 3));\n        $this->assertEquals(0, add(-1, 1));\n        $this->assertEquals(-6, add(-3, -3));\n    }\n}