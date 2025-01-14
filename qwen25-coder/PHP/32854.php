use PHPUnit\Framework\TestCase;\n\nclass myObj { \n    public function doSomethingWhichIsLogged()\n    {\n        $logger = new logger('/tmp/log.txt');\n        $logger->info('some message');\n    }\n}\n\nclass Logger {\n    public function __construct($filepath) {}\n    public function info($message) {}\n}\n\nclass TestMyObj extends TestCase\n{\n    protected function tearDown(): void\n    {\n        parent::tearDown();\n        // Reset any mocking\n        \Mockery::close();\n    }\n\n    public function testDoSomethingWhichIsLogged()\n    {\n        // Create a mock object of Logger\n        $mock = $this->createPartialMock(Logger::class, ['info']);\n\n        // Set expectations on the info method\n        $mock\n            ->expects($this->once())\n            ->method('info')\n            ->with('some message');\n\n        // Patch new instances of Logger to be our mock object\n        $patcher = $this->createPartialMock(\PHPUnit\Framework\MockObject\Generator::class, ['getMock']);\n        $patcher->method('getMock')->willReturn($mock);\n        $this->mockeryContainer()->getGeneratorService()->setPatcher(new \ReflectionClass($patcher));\n\n        // Instantiate and test myObj\n        $myObj = new myObj();\n        $myObj->doSomethingWhichIsLogged();\n    }\n}