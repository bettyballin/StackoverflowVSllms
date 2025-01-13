using System;\nusing Microsoft.Win32;\n\npublic class DotNetFrameworkVersionChecker {\n    public static void Main() {\n        CheckFor40Full();\n        CheckFor45Plus();\n        Console.WriteLine(".NET Framework Version Info:");\n        Console.WriteLine(Environment.Version);\n    }\n\n    private static void CheckFor40Full()\n    {\n        const string subkey = @"SOFTWARE\Microsoft\NET Framework Setup\NDP\v4\Client";\n\n        using (RegistryKey ndpKey = RegistryKey.OpenBaseKey(RegistryHive.LocalMachine, RegistryView.Registry32).OpenSubKey(subkey))\n        {\n            if (ndpKey != null && ndpKey.GetValue("Version") != null)\n            {\n                Console.WriteLine($".NET Framework Version: {ndpKey.GetValue("Version").ToString()}");\n            }\n            else\n            {\n                Console.WriteLine(".NET Framework 4.0 Full is not found.");\n            }\n        }\n    }\n\n    private static void CheckFor45Plus()\n    {\n        const string subkey = @"SOFTWARE\Microsoft.NETFramework\v4.0";\n\n        using (RegistryKey ndpKey = RegistryKey.OpenBaseKey(RegistryHive.LocalMachine, RegistryView.Registry32).OpenSubKey(subkey))\n        {\n            if (ndpKey != null && ndpKey.GetValue("Release") != null)\n            {\n                Console.WriteLine($"Installed .NET Framework Version: {CheckFor45PlusVersion((int) ndpKey.GetValue("Release"))}");\n            }\n            else\n            {\n                Console.WriteLine(".NET Framework 4.5+ is not found.");\n            }\n        }\n    }\n\n    private static string CheckFor45PlusVersion(int releaseKey)\n    {\n        if (releaseKey >= 528040) return "4.8 or later";\n        if (releaseKey >= 527124)\n        {\n            return releaseKey >= 527365 ? "4.7.2" : "4.7.1";\n        }\n        if (releaseKey == 527096) return "4.7";\n\n        if (releaseKey >= 461814)\n        {\n            return releaseKey >= 461818 ? "4.6.2" : "4.6.1";\n        }\n        if (releaseKey == 394802) return "4.6";\n\n        if (releaseKey >= 393297)\n        {\n            return releaseKey >= 393841 ? ".NET Framework 4.5.2" : ".NET Framework 4.5.1";\n        }\n        else\n        {\n            return releaseKey == 378675 ? "4.5" : string.Empty;\n        }\n    }\n}