public class MyObj : IComparable\n{\n    public string Symbol { get; set; }\n\n    public int CompareTo(object obj)\n    {\n        MyObj myObj = (MyObj)obj;\n        return String.Compare(this.Symbol, myObj.Symbol, true);\n    }\n\n    public override bool Equals(object obj)\n    {\n        if (obj == null || !(obj is MyObj))\n            return false;\n\n        MyObj myObj = (MyObj)obj;\n        return String.Equals(this.Symbol, myObj.Symbol, StringComparison.OrdinalIgnoreCase);\n    }\n\n    public override int GetHashCode()\n    {\n        return Symbol == null ? 0 : Symbol.GetHashCode(StringComparison.OrdinalIgnoreCase);\n    }\n}