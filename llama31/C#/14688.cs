class Foo\n{\n    private static readonly string bar = "O_o";\n\n    private bool TrySomething()\n    {\n        string bar = Foo.bar; // no lock needed\n        // Do something with bar\n    }\n}