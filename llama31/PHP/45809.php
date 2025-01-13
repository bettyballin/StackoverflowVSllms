use PHPUnit\Framework\TestCase;\nuse MyApp\Models\User;\n\nclass UserTest extends TestCase\n{\n    public function testValidation()\n    {\n        $user = new User();\n        $user->setName('John Doe');\n        $user->setEmail('john@example.com');\n\n        $this->assertTrue($user->isValid());\n    }\n\n    public function testInvalidEmail()\n    {\n        $user = new User();\n        $user->setName('John Doe');\n        $user->setEmail('invalid-email');\n\n        $this->assertFalse($user->isValid());\n    }\n}