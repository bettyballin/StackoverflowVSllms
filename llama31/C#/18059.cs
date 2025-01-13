using System;\nusing System.IO;\n\nclass Program\n{\n    static void Main(string[] args)\n    {\n        // Create two console output streams\n        var console1 = new StreamWriter(Console.OpenStandardOutput());\n        var console2 = new StreamWriter(Console.OpenStandardOutput());\n\n        // Set the output stream for console 1\n        Console.SetOut(console1);\n        Console.WriteLine("This will be written to console 1");\n\n        // Set the output stream for console 2\n        Console.SetOut(console2);\n        Console.WriteLine("This will be written to console 2");\n\n        // Don't forget to close the streams when done\n        console1.Close();\n        console2.Close();\n    }\n}