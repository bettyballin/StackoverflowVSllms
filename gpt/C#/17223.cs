public class Program\n{\n    public static void Main()\n    {\n        List<ClassA> myObjects = new List<ClassA>\n        {\n            new ClassA("A1", "B1", new ClassB("D1")),\n            new ClassA("A2", "B2", new ClassB("D2"))\n        };\n\n        // Define your custom default object\n        ClassA defaultObject = new ClassA();\n\n        // Use the custom extension method to get the element at index 3 or the custom default value\n        ClassA newObject = myObjects.ElementAtOrCustomDefault(3, defaultObject);\n\n        Console.WriteLine($"FieldA: {newObject.FieldA}, FieldB: {newObject.FieldB}, FieldC.FieldD: {newObject.FieldC.FieldD}");\n    }\n}