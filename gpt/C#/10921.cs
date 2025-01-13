class Program\n{\n    static void Main()\n    {\n        string code = @"\n        using System;\n\n        public class HelloWorld\n        {\n            public void SayHello()\n            {\n                Console.WriteLine(""Hello, world!"");\n            }\n        }";\n\n        string outputPath = "HelloWorld.dll";\n        DynamicDllGenerator generator = new DynamicDllGenerator();\n        generator.GenerateDll(code, outputPath);\n    }\n}