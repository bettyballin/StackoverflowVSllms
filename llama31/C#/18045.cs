public class MyClass\n{\n    private int _value;\n\n    public int Value => _value; // Simple property\n\n    public void DoWork()\n    {\n        int localVar = Value; // JIT may inline the getter\n        // ...\n    }\n}