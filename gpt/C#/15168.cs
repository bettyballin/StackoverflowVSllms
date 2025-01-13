using System;\nusing System.Security.Cryptography;\nusing System.Text;\nusing Microsoft.Win32;\n\npublic class SecureRegistryStorage\n{\n    public static void StoreCredentials(string username, string password)\n    {\n        byte[] encryptedPassword = Protect(password);\n        string encryptedPasswordBase64 = Convert.ToBase64String(encryptedPassword);\n\n        RegistryKey key = Registry.CurrentUser.CreateSubKey(@"Software\YourApp");\n        key.SetValue("Username", username);\n        key.SetValue("Password", encryptedPasswordBase64);\n        key.Close();\n    }\n\n    public static (string username, string password) RetrieveCredentials()\n    {\n        RegistryKey key = Registry.CurrentUser.OpenSubKey(@"Software\YourApp");\n        if (key != null)\n        {\n            string username = key.GetValue("Username") as string;\n            string encryptedPasswordBase64 = key.GetValue("Password") as string;\n            byte[] encryptedPassword = Convert.FromBase64String(encryptedPasswordBase64);\n            string password = Unprotect(encryptedPassword);\n\n            return (username, password);\n        }\n        return (null, null);\n    }\n\n    private static byte[] Protect(string data)\n    {\n        byte[] dataBytes = Encoding.UTF8.GetBytes(data);\n        return ProtectedData.Protect(dataBytes, null, DataProtectionScope.CurrentUser);\n    }\n\n    private static string Unprotect(byte[] data)\n    {\n        byte[] decryptedBytes = ProtectedData.Unprotect(data, null, DataProtectionScope.CurrentUser);\n        return Encoding.UTF8.GetString(decryptedBytes);\n    }\n}