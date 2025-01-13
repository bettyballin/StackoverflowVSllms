[AttributeUsage(AttributeTargets.Property)]\npublic class RegularExpressionAttribute : Attribute\n{\n    public string Pattern { get; }\n\n    public RegularExpressionAttribute(string pattern)\n    {\n        Pattern = pattern;\n    }\n}