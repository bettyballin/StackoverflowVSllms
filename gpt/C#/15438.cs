using System;\nusing System.Xml.Linq;\n\ninternal class Program\n{\n    private static void Main()\n    {\n        // Create example XML element\n        var x = XElement.Parse("<root><find><name>my-name</name></find></root>");\n\n        // Old way\n        var test1 = x.Element("find");\n        if (test1 != null) test1 = test1.Element("name");\n        Console.WriteLine(test1);\n\n        // Using the null-conditional operator\n        var test2 = x.Element("find")?.Element("name");\n        Console.WriteLine(test2);\n\n        Console.ReadLine();\n    }\n}