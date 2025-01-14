<?php\n\nnamespace ApplicationTest\Controller;\n\nuse Application\Controller\IndexController;\nuse Laminas\Test\PHPUnit\Controller\AbstractHttpControllerTestCase;\n\nclass IndexControllerTest extends AbstractHttpControllerTestCase\n{\n    protected function setUp(): void\n    {\n        // The module configuration should be compatible with Laminas\Mvc\Application.\n        $this->setApplicationConfig([\n            'modules' => [\n                'Application',\n            ],\n            'module_listener_options' => [\n                'config_glob_paths' => [realpath(__DIR__) . '/../../../../../config/autoload/{,*.}{global,local}-development.php'],\n                'module_paths' => [realpath(__DIR__) . '/../../../../../../'],\n            ],\n        ]);\n\n        parent::setUp();\n    }\n\n    public function testIndexActionCanBeAccessed()\n    {\n        $this->dispatch('/');\n\n        $this->assertResponseStatusCode(200);\n        // Optionally, check for expected content\n        $this->assertModuleName('Application');\n        $this->assertControllerName(IndexController::class); // as specified in router's controller name alias\n        $this->assertMatchedRouteName('home');\n    }\n}