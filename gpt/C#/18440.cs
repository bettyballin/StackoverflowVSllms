using Microsoft.Win32;\nusing System;\n\nclass Program\n{\n    static void Main()\n    {\n        bool isDotNet35Installed = IsDotNet35Installed();\n        Console.WriteLine($".NET Framework 3.5 is {(isDotNet35Installed ? "installed" : "not installed")}.");\n    }\n\n    static bool IsDotNet35Installed()\n    {\n        const string subkey = @"SOFTWARE\Microsoft\NET Framework Setup\NDP\v3.5";\n        using (RegistryKey key = Registry.LocalMachine.OpenSubKey(subkey))\n        {\n            if (key != null)\n            {\n                object install = key.GetValue("Install");\n                if (install != null && (int)install == 1)\n                {\n                    return true;\n                }\n            }\n        }\n        return false;\n    }\n}