public MyClass(string name)\n{\n    if (string.IsNullOrWhiteSpace(name))\n    {\n        throw new ArgumentException("Name cannot be null, empty, or whitespace-only", nameof(name));\n    }\n    this.Name = name;\n}