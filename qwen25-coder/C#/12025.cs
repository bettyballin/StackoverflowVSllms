public class MyType\n{\n    // Overloaded operator to allow (MyType)double syntax\n    public static implicit operator MyType(double value)\n    {\n        return new MyType { Value = value };\n    }\n\n    // Explicit method for the same operation\n    public static MyType FromDouble(double value)\n    {\n        return (MyType)value;\n    }\n\n    // Overloaded operator to allow (double)myType syntax\n    public static explicit operator double(MyType myType)\n    {\n        return myType.Value;\n    }\n\n    // Explicit method for the same operation\n    public double ToDouble()\n    {\n        return (double)this;\n    }\n\n    // Properties or fields\n    public double Value { get; set; }\n}