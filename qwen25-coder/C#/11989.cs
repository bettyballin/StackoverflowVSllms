using System.IO;\n\n// Writing to a file\nFile.WriteAllText(@"C:\Config\MyAppSettings.ini", "MySetting=Enabled");\n\n// Reading from a file\nstring fileContent = File.ReadAllText(@"C:\Config\MyAppSettings.ini");