using Microsoft.Win32;\nusing System;\n\nclass Program {\n    static void Main() {\n        WriteToRegistry();\n        ReadFromRegistry();\n    }\n\n    static void WriteToRegistry() {\n        RegistryKey key = Registry.CurrentUser.CreateSubKey(@"SOFTWARE\MyApp");\n        if (key != null) {\n            key.SetValue("MyValue", 1, RegistryValueKind.DWord);\n            key.Close();\n            Console.WriteLine("Value written successfully.");\n        } else {\n            Console.WriteLine("Error creating/opening key.");\n        }\n    }\n\n    static void ReadFromRegistry() {\n        RegistryKey key = Registry.CurrentUser.OpenSubKey(@"SOFTWARE\MyApp");\n        if (key != null) {\n            object value = key.GetValue("MyValue");\n            if (value != null) {\n                Console.WriteLine("Value read successfully: " + value);\n            } else {\n                Console.WriteLine("Error querying value.");\n            }\n            key.Close();\n        } else {\n            Console.WriteLine("Error opening key.");\n        }\n    }\n}