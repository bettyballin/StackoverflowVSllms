using System;\nusing System.IO;\nusing System.Security;\nusing System.Security.Cryptography;\nusing System.Text;\n\npublic class PasswordManager\n{\n    public static void StorePassword(string filePath, SecureString password)\n    {\n        byte[] encryptedData = ProtectedData.Protect(\n            Encoding.UTF8.GetBytes(ConvertToUnsecureString(password)), \n            null, \n            DataProtectionScope.CurrentUser);\n\n        File.WriteAllBytes(filePath, encryptedData);\n    }\n\n    public static SecureString RetrievePassword(string filePath)\n    {\n        byte[] encryptedData = File.ReadAllBytes(filePath);\n        \n        byte[] decryptedData = ProtectedData.Unprotect(\n            encryptedData, \n            null, \n            DataProtectionScope.CurrentUser);\n\n        return ConvertToSecureString(Encoding.UTF8.GetString(decryptedData));\n    }\n\n    private static string ConvertToUnsecureString(SecureString secureString)\n    {\n        if (secureString == null)\n            throw new ArgumentNullException("secureString");\n\n        IntPtr unmanagedString = IntPtr.Zero;\n        try\n        {\n            unmanagedString = System.Runtime.InteropServices.Marshal.SecureStringToGlobalAllocUnicode(secureString);\n            return System.Runtime.InteropServices.Marshal.PtrToStringUni(unmanagedString);\n        }\n        finally\n        {\n            System.Runtime.InteropServices.Marshal.ZeroFreeGlobalAllocUnicode(unmanagedString);\n        }\n    }\n\n    private static SecureString ConvertToSecureString(string password)\n    {\n        if (password == null)\n            throw new ArgumentNullException("password");\n\n        SecureString securePassword = new SecureString();\n        foreach (char c in password)\n        {\n            securePassword.AppendChar(c);\n        }\n        securePassword.MakeReadOnly();\n        return securePassword;\n    }\n}