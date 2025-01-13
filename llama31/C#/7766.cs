// Compile this code into a DLL\npublic class MyLibrary {\n    public static void DoSomething() {\n        Console.WriteLine("Hello, world!");\n    }\n}\n\n// Compile this code into an assembly (e.g., MyAssembly.dll)\nusing System.Reflection;\n\n[assembly: AssemblyTitle("MyAssembly")]\n[assembly: AssemblyVersion("1.0.0.0")]\n\npublic class MyAssembly {\n    public static void Main(string[] args) {\n        MyLibrary.DoSomething();\n    }\n}