using System;\nusing VB = Microsoft.VisualBasic;\n\n\nnamespace ConsoleApplication1\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            Console.WriteLine(VB.Strings.StrConv("QUICK BROWN", VB.VbStrConv.ProperCase, 0));\n            Console.ReadLine();\n        }\n    }\n}