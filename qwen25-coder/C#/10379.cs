using System;\nusing Microsoft.Win32;\n\npublic class ComLibraryChecker\n{\n    public static bool IsComLibraryInstalled(string clsid)\n    {\n        // Construct the registry path\n        string keyPath = $"CLSID\\{{{clsid}}}";\n\n        // Try to open the registry key\n        using (RegistryKey key = Registry.ClassesRoot.OpenSubKey(keyPath))\n        {\n            return key != null;\n        }\n    }\n\n    public static void Main()\n    {\n        string clsidToCheck = "Your-CLSID-Goes-Here"; // Replace with the CLSID you want to check\n\n        if (IsComLibraryInstalled(clsidToCheck))\n        {\n            Console.WriteLine("COM library is installed.");\n        }\n        else\n        {\n            Console.WriteLine("COM library is not installed.");\n        }\n    }\n}