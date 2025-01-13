using System;\nusing System.Runtime.InteropServices;\n\n[ComVisible(true)]\npublic static class ComRegistrationHelper\n{\n    [ComRegisterFunction]\n    public static void RegisterClass(string key)\n    {\n        // Custom code for registration\n        Console.WriteLine("Custom registration logic executed.");\n    }\n\n    [ComUnregisterFunction]\n    public static void UnregisterClass(string key)\n    {\n        // Custom code for unregistration\n        Console.WriteLine("Custom unregistration logic executed.");\n    }\n}