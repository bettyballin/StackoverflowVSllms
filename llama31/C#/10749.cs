using Microsoft.Win32;\n\nstring clsid = "Your_CLSID_here";\nRegistryKey key = Registry.ClassesRoot.OpenSubKey(@"CLSID\" + clsid);\nif (key != null)\n{\n    RegistryKey serverKey = key.OpenSubKey("InprocServer32");\n    if (serverKey != null)\n    {\n        string dllPath = serverKey.GetValue(null) as string;\n        Console.WriteLine(dllPath);\n    }\n}