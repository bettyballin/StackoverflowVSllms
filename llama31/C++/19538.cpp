// C++/CLI wrapper\npublic ref class MyClassWrapper\n{\npublic:\n    MyClassWrapper()\n    {\n        // Create an instance of the C++ class\n        myClass_ = new MyClass();\n    }\n\n    ~MyClassWrapper()\n    {\n        delete myClass_;\n    }\n\n    void MyMethod()\n    {\n        myClass_->MyMethod();\n    }\n\nprivate:\n    MyClass* myClass_;\n};