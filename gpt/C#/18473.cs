using System;\nusing Microsoft.Win32;\n\nclass ExcelVersionDetector\n{\n    static void Main()\n    {\n        string excelVersion = GetExcelVersion();\n        string servicePack = GetExcelServicePack();\n\n        Console.WriteLine($"Excel Version: {excelVersion}");\n        if (!string.IsNullOrEmpty(servicePack))\n        {\n            Console.WriteLine($"Service Pack: {servicePack}");\n        }\n        else\n        {\n            Console.WriteLine("No Service Pack information found.");\n        }\n    }\n\n    static string GetExcelVersion()\n    {\n        string version = string.Empty;\n        RegistryKey registryKey = Registry.LocalMachine.OpenSubKey(@"SOFTWARE\Microsoft\Office\Excel");\n\n        if (registryKey != null)\n        {\n            foreach (string subKeyName in registryKey.GetSubKeyNames())\n            {\n                if (subKeyName.StartsWith("1") && subKeyName.Length == 2)\n                {\n                    version = subKeyName;\n                    break;\n                }\n            }\n        }\n\n        return version;\n    }\n\n    static string GetExcelServicePack()\n    {\n        string servicePack = string.Empty;\n        RegistryKey registryKey = Registry.LocalMachine.OpenSubKey(@"SOFTWARE\Microsoft\Office\Excel");\n\n        if (registryKey != null)\n        {\n            foreach (string subKeyName in registryKey.GetSubKeyNames())\n            {\n                if (subKeyName.StartsWith("1") && subKeyName.Length == 2)\n                {\n                    RegistryKey versionKey = registryKey.OpenSubKey(subKeyName);\n                    if (versionKey != null)\n                    {\n                        servicePack = versionKey.GetValue("ServicePack") as string;\n                        break;\n                    }\n                }\n            }\n        }\n\n        return servicePack;\n    }\n}