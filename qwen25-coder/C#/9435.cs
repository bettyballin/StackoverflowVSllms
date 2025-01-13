using Microsoft.Win32;\n\nstring subkey = @"SOFTWARE\Microsoft\NET Framework Setup\NDP\v4\Full";\nusing (RegistryKey key = Registry.LocalMachine.OpenSubKey(subkey))\n{\n    if (key != null && key.GetValue("Version") != null)\n        Console.WriteLine(key.GetValue("Version"));\n}