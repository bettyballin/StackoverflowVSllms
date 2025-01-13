using Microsoft.Win32;\n\npublic void AssociateFileType(string extension, string progId, string fileTypeDescription, string applicationPath)\n{\n    using (var regKey = Registry.CurrentUser.CreateSubKey($@"Software\Classes\.{extension}"))\n    {\n        regKey.SetValue("", progId);\n    }\n\n    using (var regKey = Registry.CurrentUser.CreateSubKey($@"Software\Classes\{progId}"))\n    {\n        regKey.SetValue("", fileTypeDescription);\n\n        using (var shellKey = regKey.CreateSubKey("shell\\open\\command"))\n        {\n            shellKey.SetValue("", "\"" + applicationPath + "\" \"%1\"");\n        }\n    }\n}