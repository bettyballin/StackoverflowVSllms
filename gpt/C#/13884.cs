using System;\nusing System.Management;\n\npublic class OSArchChecker\n{\n    public static bool Is64BitOperatingSystem()\n    {\n        bool is64Bit = false;\n        try\n        {\n            using (ManagementObjectSearcher searcher = new ManagementObjectSearcher("SELECT OSArchitecture FROM Win32_OperatingSystem"))\n            {\n                foreach (ManagementObject mo in searcher.Get())\n                {\n                    string osArchitecture = mo["OSArchitecture"].ToString();\n                    if (osArchitecture.Contains("64"))\n                    {\n                        is64Bit = true;\n                    }\n                }\n            }\n        }\n        catch (Exception e)\n        {\n            Console.WriteLine("An error occurred: " + e.Message);\n        }\n        return is64Bit;\n    }\n}