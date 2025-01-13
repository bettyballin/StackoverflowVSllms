using Microsoft.Win32;\n\npublic class FileAssociation\n{\n    public static void CaptureFileType(string extension, string progId, string applicationPath)\n    {\n        // Create or open the registry key for the file extension\n        using (RegistryKey key = Registry.ClassesRoot.CreateSubKey(extension))\n        {\n            key.SetValue("", progId);\n        }\n\n        // Create or open the registry key for the program ID\n        using (RegistryKey key = Registry.ClassesRoot.CreateSubKey(progId))\n        {\n            key.SetValue("", "Description of file type");\n            key.CreateSubKey("DefaultIcon").SetValue("", applicationPath + ",0");\n            key.CreateSubKey(@"Shell\Open\Command").SetValue("", "\"" + applicationPath + "\" \"%1\"");\n        }\n    }\n\n    public static void RestoreFileType(string extension)\n    {\n        // Delete the registry key for the file extension\n        Registry.ClassesRoot.DeleteSubKeyTree(extension, false);\n    }\n}\n\n// Usage example\n// Capture .lala files\nFileAssociation.CaptureFileType(".lala", "MyApp.lala", @"C:\Path\To\MyApp.exe");\n\n// Restore .lala files to their default association\nFileAssociation.RestoreFileType(".lala");