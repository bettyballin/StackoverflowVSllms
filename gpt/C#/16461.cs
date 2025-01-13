using Microsoft.Win32;\nusing System;\n\nclass Program\n{\n    static void Main()\n    {\n        // Define the registry path for Internet Explorer security zones\n        string registryPath = @"Software\Microsoft\Windows\CurrentVersion\Internet Settings\Zones";\n\n        // Define the security zones\n        string[] zones = { "0", "1", "2", "3", "4" };\n\n        foreach (string zone in zones)\n        {\n            string zonePath = $"{registryPath}\\{zone}";\n            using (RegistryKey key = Registry.CurrentUser.OpenSubKey(zonePath))\n            {\n                if (key != null)\n                {\n                    // Fetch specific security settings\n                    object value = key.GetValue("1406"); // 1406 is the registry key for ActiveX controls and plugins\n                    if (value != null)\n                    {\n                        int setting = (int)value;\n                        Console.WriteLine($"Zone {zone}: ActiveX setting = {setting}");\n                    }\n                }\n            }\n        }\n    }\n}