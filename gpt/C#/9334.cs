using Microsoft.Win32;\nusing System;\nusing System.Security.AccessControl;\n\npublic class RegistryPermissionChecker\n{\n    public static bool HasRegistryKeyPermission(string registryKeyPath, RegistryRights rights)\n    {\n        try\n        {\n            using (RegistryKey key = Registry.LocalMachine.OpenSubKey(registryKeyPath, false))\n            {\n                if (key == null)\n                {\n                    Console.WriteLine("Registry key does not exist.");\n                    return false;\n                }\n\n                RegistrySecurity security = key.GetAccessControl();\n                AuthorizationRuleCollection rules = security.GetAccessRules(true, true, typeof(System.Security.Principal.NTAccount));\n\n                foreach (AuthorizationRule rule in rules)\n                {\n                    RegistryAccessRule accessRule = (RegistryAccessRule)rule;\n\n                    if ((accessRule.RegistryRights & rights) == rights)\n                    {\n                        return true;\n                    }\n                }\n            }\n        }\n        catch (UnauthorizedAccessException)\n        {\n            // Handle the case where access to the registry key is denied\n        }\n        catch (Exception ex)\n        {\n            // Handle other potential exceptions\n            Console.WriteLine($"An exception occurred: {ex.Message}");\n        }\n\n        return false;\n    }\n\n    public static void Main()\n    {\n        string registryKeyPath = @"SOFTWARE\Microsoft\Windows\CurrentVersion\Run";\n\n        bool hasReadPermission = HasRegistryKeyPermission(registryKeyPath, RegistryRights.ReadKey);\n        bool hasWritePermission = HasRegistryKeyPermission(registryKeyPath, RegistryRights.WriteKey);\n\n        Console.WriteLine($"Read Permission: {hasReadPermission}");\n        Console.WriteLine($"Write Permission: {hasWritePermission}");\n    }\n}