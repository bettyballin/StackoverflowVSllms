public static class Storage\n{\n    private static readonly object lockObject = new object();\n    private static string _filePath;\n\n    public static string FilePath\n    {\n        get\n        {\n            lock (lockObject)\n            {\n                return _filePath;\n            }\n        }\n        set\n        {\n            lock (lockObject)\n            {\n                _filePath = value;\n            }\n        }\n    }\n}