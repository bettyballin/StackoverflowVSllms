$suite = new PHPUnit\Framework\TestSuite();\n$suite->addTestFile('/path/to/TU.php'); // This assumes TU adds other test files internally\n\nreturn $suite;