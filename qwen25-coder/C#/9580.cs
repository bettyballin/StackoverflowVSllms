using System;\nusing System.Runtime.InteropServices;\n\n[ComVisible(true)]\n[Guid("YOUR-GUID-HERE")]\npublic interface IMyInterface\n{\n    object GetNestedArray();\n}\n\n[ComVisible(true)]\n[Guid("ANOTHER-GUID-HERE")]\n[ClassInterface(ClassInterfaceType.None)]\npublic class MyClass : IMyInterface\n{\n    public object GetNestedArray()\n    {\n        string[][] nestedArray = new string[][]\n        {\n            new string[] { "Hello", "World" },\n            new string[] { "Foo", "Bar" }\n        };\n\n        return nestedArray;\n    }\n}