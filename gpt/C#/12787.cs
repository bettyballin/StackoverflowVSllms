using Microsoft.Win32;\nusing System;\n\nnamespace NameHere\n{\n    class Program\n    {\n        static void Main(string[] args)\n        {\n            try\n            {\n                string strKey = "Test123";\n                string fullPath = @"SYSTEM\CurrentControlSet\Control\Print\Environments\Windows NT x86\" + strKey;\n                DeleteRegKey(fullPath);\n                Console.WriteLine("Registry key deleted successfully.");\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("Error: " + ex.Message);\n            }\n        }\n\n        static void DeleteRegKey(string keyName)\n        {\n            try\n            {\n                using (RegistryKey hklm = Registry.LocalMachine.OpenSubKey(keyName, true))\n                {\n                    if (hklm != null)\n                    {\n                        Registry.LocalMachine.DeleteSubKey(keyName);\n                    }\n                    else\n                    {\n                        Console.WriteLine("Registry key does not exist.");\n                    }\n                }\n            }\n            catch (UnauthorizedAccessException)\n            {\n                Console.WriteLine("Error: Access denied. Ensure you have the necessary permissions.");\n            }\n            catch (Exception ex)\n            {\n                Console.WriteLine("Error: " + ex.Message);\n            }\n        }\n    }\n}