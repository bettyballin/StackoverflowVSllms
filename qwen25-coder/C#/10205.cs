public class A : Player\n{\n    private int desiredPower = 100;\n\n    public override int GetPower => desiredPower;\n    \n    protected A() : base()\n    {\n        InitializePower();\n    }\n}