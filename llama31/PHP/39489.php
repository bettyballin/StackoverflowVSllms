use Zend\Test\PHPUnit\Controller\AbstractHttpControllerTestCase;\n\nclass IndexControllerTest extends AbstractHttpControllerTestCase\n{\n    public function setUp()\n    {\n        $this->setApplicationConfig(\n            include __DIR__ . '/../../../../../config/application.config.php'\n        );\n        parent::setUp();\n    }\n\n    public function testIndexActionCanBeAccessed()\n    {\n        $this->dispatch('/');\n        $this->assertResponseStatusCode(200);\n        $this->assertModuleName('application');\n        $this->assertControllerName('Application\Controller\Index');\n        $this->assertControllerClass('IndexController');\n        $this->assertActionName('index');\n    }\n}