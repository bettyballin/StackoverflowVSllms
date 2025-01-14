class CreateFileLinkTest extends \PHPUnit\Framework\TestCase\n{\n    public function testCreateFileLinkReturnsDateString()\n    {\n        // Call the function\n        $result = CreateFileLink();\n\n        // Define the expected format as a regular expression\n        $expectedFormat = '/^\d{2}-\d{2}-\d{2}-\d{1,2}-\d{2}$/';\n\n        // Assert that the result matches the expected date format\n        $this->assertMatchesRegularExpression($expectedFormat, $result);\n    }\n}