using System.Security.Permissions;\n    using Microsoft.Win32;\n\n    public class Program\n    {\n        [RegistryPermission(SecurityAction.Demand, Read = "HKEY_LOCAL_MACHINE\\YourSubKey")]\n        public static void Main(string[] args)\n        {\n            // Your code to access the registry\n            RegistryKey key = Registry.LocalMachine.OpenSubKey("YourSubKey", true);\n            // Perform your read, write, delete operations\n        }\n    }