internal class ObjManager\n{\n    internal List<Obj> returnStuff()\n    {\n        return getSomeStuff().OfType<Obj>().ToList();\n    }\n\n    private List<ObjBase> getSomeStuff()\n    {\n        return new List<ObjBase>();\n    }\n}