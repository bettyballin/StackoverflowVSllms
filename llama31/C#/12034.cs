// Before\npublic class MyClass\n{\n    public void MyMethod() { }\n}\n\n// After (safe changes)\npublic class MyClass\n{\n    public void MyMethod() { }\n    public void NewMethod() { } // added new method\n}\n\npublic class NewClass\n{\n    public void NewMethod() { } // added new class\n}