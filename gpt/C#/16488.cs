interface IExample {\n        void Display();\n    }\n    \n    struct ExampleStruct : IExample {\n        public void Display() {\n            Console.WriteLine("ExampleStruct Display");\n        }\n    }\n    \n    void Show(IExample example) {\n        example.Display();\n    }\n    \n    ExampleStruct example = new ExampleStruct();\n    Show(example);  // Boxing occurs here