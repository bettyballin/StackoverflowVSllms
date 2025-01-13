using System;\nusing System.Security.Principal;\nusing System.Runtime.InteropServices;\n\nclass Program\n{\n    [DllImport("advapi32.dll", SetLastError = true, CharSet = CharSet.Unicode)]\n    static extern bool LogonUser(string lpszUsername, string lpszDomain, string lpszPassword, int dwLogonType, int dwLogonProvider, out IntPtr phToken);\n\n    static void Main(string[] args)\n    {\n        string username = "username";\n        string domain = "domain";\n        string password = "password";\n\n        IntPtr token;\n        if (LogonUser(username, domain, password, 3, 0, out token))\n        {\n            using (WindowsIdentity.Impersonate(token))\n            {\n                Console.WriteLine("Impersonated identity: " + WindowsIdentity.GetCurrent().Name);\n            }\n        }\n        else\n        {\n            Console.WriteLine("Impersonation failed: " + Marshal.GetLastWin32Error());\n        }\n    }\n}