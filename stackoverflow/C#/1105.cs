using System;\nusing System.Linq.Expressions;\n\ninterface IKeyed<TKey>\n{\n    TKey Key { get; }\n}\n\nclass KeyedThing : IKeyed<int>\n{\n    public int Key { get { return 1; } }\n}\n\nclass KeyedThingGetter<TThing, TKey> where TThing : IKeyed<TKey>\n{\n    public void GetThing()\n    {\n        Func<TThing, bool> f = thing => thing.Key.Equals(1);\n        Expression<Func<TThing, bool>> e = thing => thing.Key.Equals(1);\n    }\n}\n\nclass Test\n{\n    static void Main()\n    {\n        var g = new KeyedThingGetter<KeyedThing, int>();\n        g.GetThing();\n    }\n}