public class MainApp \n{\n    public void Run()\n    {\n        SomeClass _class = null;\n        try\n        {\n            _class = new SomeClass();\n            _class.SomeMethod();\n            // Use the resource in your application logic here\n        }\n        finally\n        {\n            if (_class != null)\n            {\n                _class.Dispose();\n            }\n        }\n    }\n}