using System;\nusing System.Collections.Generic;\n\npublic class Example\n{\n    public static void Main()\n    {\n        LinkedList<int> linkedList = new LinkedList<int>();\n        \n        // Add elements\n        linkedList.AddLast(1);\n        linkedList.AddLast(2);\n        linkedList.AddLast(3);\n        \n        // GetEnumerator\n        foreach (var item in linkedList)\n        {\n            Console.WriteLine(item);\n        }\n        \n        // Clear\n        linkedList.Clear();\n    }\n}