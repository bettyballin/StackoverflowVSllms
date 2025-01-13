[ComVisible(true)]\npublic interface ITest\n{\n    string Name { get; }\n    double Date { get; }\n}\n\n[Serializable]\n[ComVisible(true)]\npublic class Test : ITest\n{\n    public string Name { get; private set; }\n    private DateTime _date;\n    \n    public double Date \n    { \n        get \n        { \n            return _date.ToOADate(); \n        } \n    }\n    \n    public Test(string name, DateTime date)\n    {\n        Name = name;\n        _date = date;\n    }\n}