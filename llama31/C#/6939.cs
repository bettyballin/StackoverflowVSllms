public sealed class MyType\n{\n    public int Id { get; private set; }\n    public string Name { get; private set; }\n\n    private MyType(int id, string name)\n    {\n        Id = id;\n        Name = name;\n    }\n\n    public static readonly MyType Type1 = new MyType(1, "Type 1");\n    public static readonly MyType Type2 = new MyType(2, "Type 2");\n    // Add more types as needed\n\n    public static MyType GetById(int id)\n    {\n        // You can implement a more efficient lookup if needed\n        return new[] { Type1, Type2 }.FirstOrDefault(t => t.Id == id);\n    }\n}