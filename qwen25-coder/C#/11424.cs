using System;\nusing Microsoft.CSharp;\n\nclass Program\n{\n    static void Main()\n    {\n        string className = "myClass1";\n        \n        if (IsValidClassName(className))\n        {\n            Console.WriteLine($"{className} is a valid C# class name.");\n        }\n        else\n        {\n            Console.WriteLine($"{className} is NOT a valid C# class name.");\n        }\n    }\n\n    public static bool IsValidClassName(string name)\n    {\n        var provider = new CSharpCodeProvider();\n        // Check if it's a valid identifier\n        if (!provider.IsValidIdentifier(name))\n            return false;\n        \n        // Check if it's a reserved keyword in C#\n        CSharpCodeParser parser = new CSharpCodeParser();\n        bool isKeyword = parser.IsKnownContextualKeyword(name)\n                         || Tokenizer.IsReservedWord(name);\n        \n        return !isKeyword;\n    }\n}\n\nclass Tokenizer\n{\n    private static readonly HashSet<string> keywords = new HashSet<string>\n    {\n        "abstract", "as", "base", "bool", "break", "byte", "case", "catch", "char",\n        "checked", "class", "const", "continue", "decimal", "default", "delegate",\n        "do", "double", "else", "enum", "event", "explicit", "extern", "false", "finally",\n        "fixed", "float", "for", "foreach", "goto", "if", "implicit", "in", "int",\n        "interface", "internal", "is", "lock", "long", "namespace", "new", "null", "object",\n        "operator", "out", "override", "params", "private", "protected", "public", "readonly",\n        "ref", "return", "sbyte", "sealed", "short", "sizeof", "stackalloc", "static", "string",\n        "struct", "switch", "this", "throw", "true", "try", "typeof", "uint", "ulong", "unchecked",\n        "unsafe", "ushort", "using", "virtual", "void", "volatile", "while"\n    };\n\n    public static bool IsReservedWord(string word)\n    {\n        return keywords.Contains(word);\n    }\n}