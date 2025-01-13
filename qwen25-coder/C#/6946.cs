using System;\nusing System.Collections.Generic;\nusing System.Collections.ObjectModel;\n\nclass Program\n{\n    static void Main()\n    {\n        // Using List<T>\n        List<int> listOfIntegers = new List<int>();\n        listOfIntegers.Add(1);\n        listOfIntegers.Add(2);\n\n        // Using Collection<T>, typically extended\n        MyCollection myCustomList = new MyCollection();\n        myCustomList.Add("Hello");\n        myCustomList.Add("World");\n    }\n}\n\n// A custom collection by inheriting Collection<T>\npublic class MyCollection : Collection<string>\n{\n    protected override void InsertItem(int index, string item)\n    {\n        // Custom behavior can be added here\n        base.InsertItem(index, item);\n    }\n\n    protected override void SetItem(int index, string item)\n    {\n        // Custom behavior can be added here\n        base.SetItem(index, item);\n    }\n}