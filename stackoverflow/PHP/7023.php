class Test\n{\n\n    public function test($methodName) {\n        $this->$methodName();\n    }\n\n    private function a() {\n        echo("a");\n    }\n\n    private function b() {\n        echo("b");\n    }\n\n}\n\n$testObj = new Test();\n$testObj->test("a");\n$testObj->test("b");