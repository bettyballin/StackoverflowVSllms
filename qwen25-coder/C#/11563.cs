public class MaxLengthAttribute : System.Attribute {\n    public int Value { get; }\n    public MaxLengthAttribute(int value) => Value = value;\n}