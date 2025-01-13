using System;\nusing System.Security.Principal;\nusing System.Security;\nusing System.Runtime.InteropServices;\n\npublic class ExchangeImpersonator\n{\n    [DllImport("advapi32.dll", SetLastError = true, CharSet = CharSet.Unicode)]\n    static extern bool LogonUser(string lpszUsername, string lpszDomain, string lpszPassword, int dwLogonType, int dwLogonProvider, out IntPtr phToken);\n\n    public void Impersonate(string username, string domain, string password)\n    {\n        SecureString securePassword = new SecureString();\n        foreach (char c in password)\n        {\n            securePassword.AppendChar(c);\n        }\n        securePassword.MakeReadOnly();\n\n        IntPtr tokenHandle;\n        if (LogonUser(username, domain, securePassword.ToString(), 9, 0, out tokenHandle))\n        {\n            WindowsIdentity identity = new WindowsIdentity(tokenHandle);\n            identity.Impersonate();\n        }\n        else\n        {\n            throw new Exception("Impersonation failed");\n        }\n    }\n\n    public void UndoImpersonation()\n    {\n        WindowsIdentity identity = WindowsIdentity.GetCurrent();\n        identity.Impersonate(IntPtr.Zero);\n    }\n}