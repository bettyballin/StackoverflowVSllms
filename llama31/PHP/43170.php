amespace MyCompany\Internal;\n\nclass MyClass {\n    public function myMethod(MyOtherClass $param) {\n        // ...\n    }\n}\n\nclass MyOtherClass {\n    public function myOtherMethod(MyClass $param) {\n        // ...\n    }\n}