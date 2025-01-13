using System;\n\n[AttributeUsage(AttributeTargets.Method | AttributeTargets.Class | AttributeTargets.Property, Inherited = false, AllowMultiple = false)]\nsealed class MyAttribute : Attribute\n{\n    public string Message { get; }\n\n    public MyAttribute(string message) => Message = message;\n}