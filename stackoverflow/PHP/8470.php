<?php\nclass StubTest extends PHPUnit_Framework_TestCase\n{\n    public function testReturnCallbackStub()\n    {\n        $stub = $this->getMock(\n          'SomeClass', array('doSomething')\n        );\n\n        $stub->expects($this->any())\n             ->method('doSomething')\n             ->will($this->returnCallback('callback'));\n\n        // $stub->doSomething() returns callback(...)\n    }\n}\n\nfunction callback() {\n    $args = func_get_args();\n    // ...\n}\n?>