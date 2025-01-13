[AttributeUsage(AttributeTargets.Class)]\npublic class MyCustomAttribute : Attribute\n{\n    public string Description { get; }\n\n    // Constructor runs when accessing this attribute via reflection\n    public MyCustomAttribute(string description)\n    {\n        Description = description;\n    }\n}\n\n[MyCustom("This is a test.")]\npublic class TestClass\n{\n    \n}