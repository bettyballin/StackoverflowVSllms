public static class Ensures\n{\n    public static Validation That { get { ... } }\n\n    public static Validation WhileDebuggingThat\n    {\n        get\n        {\n#if DEBUG\n            return That;\n#else\n            return null; // or some other "no-op" implementation\n#endif\n        }\n    }\n}