use PHPUnit\Framework\TestSuite;\n\nclass MyTestFW {\n    public static function suite() {\n        // Do framework initialization here\n\n        $suite = new TestSuite();\n        $suite->addTestSuite('SimpleTest'); // Note the change here\n\n        // Add more tests\n\n        return $suite;\n    }\n}