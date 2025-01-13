public MyClass(string name)\n{\n    if (name == null || string.IsNullOrEmpty(name))\n        throw new ArgumentException("Name cannot be null or blank", nameof(name));\n\n    this.Name = name;\n}