class Test\n{\n    public function test($methodName) {\n        if (method_exists($this, $methodName)) {\n            $this->$methodName();\n        } else {\n            throw new Exception("Method $methodName does not exist");\n        }\n    }\n\n    private function a() {\n        echo("a");\n    }\n\n    private function b() {\n        echo("b");\n    }\n}\n\n$testObj = new Test();\n$testObj->test("a");\n$testObj->test("b");