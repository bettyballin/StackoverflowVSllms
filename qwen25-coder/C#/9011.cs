public class BaseClass\n{\n    public BaseClass(int arg1) { }\n    public BaseClass(int arg1, string arg2) { }\n}\n\npublic class DerivedClass : BaseClass\n{\n    // Using ReSharper or manually typing this with assistance from Visual Studio completion\n    public DerivedClass(int arg1, string arg2) : base(arg1, arg2)\n    {\n        \n    }\n}