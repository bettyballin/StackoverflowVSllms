public class Example\n{\n    public void CallUnmanagedCode()\n    {\n        int result = NativeMethods.AddNumbers(5, 7);\n        Console.WriteLine("Result: " + result);\n    }\n}