[CLSCompliant(true)]\npublic struct Number\n{\n    public int Value { get; }\n\n    public Number(int value)\n    {\n        Value = value;\n    }\n\n    // Operator overload\n    public static Number operator +(Number a, Number b) => new Number(a.Value + b.Value);\n\n    // Alternative method for languages that do not support operator overloading\n    public static Number Add(Number a, Number b) => a + b;\n}