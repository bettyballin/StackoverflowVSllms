using System;\n\npublic class Foo\n{\n    int x;\n\n    public Foo(int x)\n    {\n        this.x = x;\n    }\n}\n\npublic class Test\n{\n    static void Main(string[] args)\n    {\n        int length = int.Parse(args[0]);\n\n        Foo x = new Foo(0);\n        Foo[] array = new Foo[length];\n        // Make sure that JITting the string constructor doesn't\n        // change things\n        long start = GC.GetTotalMemory(true);\n        for (int i=0; i < length; i++)\n        {\n            array[i] = new Foo(i);\n        }\n        long end = GC.GetTotalMemory(true);\n\n        GC.KeepAlive(array);\n        GC.KeepAlive(x);\n\n        decimal totalDecimal = end-start;\n        Console.WriteLine(totalDecimal / length);\n    }\n}