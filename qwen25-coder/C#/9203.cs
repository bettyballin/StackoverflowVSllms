public static class Program\n{\n    private static void Main(string[] args)\n    {\n#if OFFICE_2003\n        IOfficeWrapper wrapper = new Office2003Wrapper();\n#elif OFFICE_2007\n        IOfficeWrapper wrapper = new Office2007Wrapper();\n#else\n#error No target office version specified. Use /define:OFFICE_2003 or /define:OFFICE_2007.\n#endif\n\n        wrapper.CreateDocument();\n    }\n}