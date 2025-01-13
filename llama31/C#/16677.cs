public partial class MyTable\n{\n    public void Validate()\n    {\n        var maxLength = GetMaxLength(typeof(MyTable), "MyStringField");\n        if (MyStringField.Length > maxLength)\n        {\n            throw new ValidationException("MyStringField is too long");\n        }\n    }\n}