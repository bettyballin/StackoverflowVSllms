public delegate T SubtractDelegate<T>(T a, T b);\n\npublic class MyGenericClass<T>\n{\n    private readonly SubtractDelegate<T> subtract;\n\n    public MyGenericClass(SubtractDelegate<T> subtract)\n    {\n        this.subtract = subtract;\n    }\n\n    public T Subtract(T a, T b)\n    {\n        return subtract(a, b);\n    }\n}\n\npublic class MyType\n{\n    public int Value { get; set; }\n\n    public static MyType operator -(MyType a, MyType b)\n    {\n        return new MyType { Value = a.Value - b.Value };\n    }\n}\n\n// Usage:\nMyGenericClass<MyType> myClass = new MyGenericClass<MyType>((a, b) => a - b);