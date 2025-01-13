// Define an invariant interface for the generic class\npublic interface ISomeInterface { }\n\n// Make SomeClass implement this interface\npublic class SomeClass<T> : ISomeInterface { }\n\npublic class C {\n    // Use List of ISomeInterface to store instances of SomeClass<T>\n    private readonly List<ISomeInterface> list = new List<ISomeInterface>();\n\n    public void Method<T>(SomeClass<T> obj) {\n        list.Add(obj);\n    }\n}