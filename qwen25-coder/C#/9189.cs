using System;\nusing System.Security.Principal;\nusing System.ServiceModel.Security;\n\npublic class Impersonator : IDisposable\n{\n    private WindowsImpersonationContext _impersonationContext;\n\n    public Impersonator(string domain, string username, string password)\n    {\n        var identity = new WindowsIdentity(GetUserToken(domain, username, password));\n        _impersonationContext = identity.Impersonate();\n    }\n\n    private static IntPtr GetUserToken(string domain, string username, string password)\n    {\n        const int LOGON32_PROVIDER_DEFAULT = 0;\n        const int LOGON32_LOGON_INTERACTIVE = 2;\n\n        if (!Security.Principal.WindowsIdentity.LogonUser(\n            username, \n            domain, \n            password, \n            LOGON32_LOGON_INTERACTIVE,\n            LOGON32_PROVIDER_DEFAULT,\n            out var result))\n        {\n            throw new ApplicationException("Failed to impersonate");\n        }\n        \n        return result;\n    }\n\n    public void Dispose()\n    {\n        _impersonationContext?.Undo();\n    }\n}\n\n// Usage in your specific class:\npublic class ExchangeManager\n{\n    private readonly string _domain;\n    private readonly string _adminUsername;\n    private readonly string _adminPassword;\n\n    // Typically, these come from a secure configuration source\n    public ExchangeManager(string domain, string adminUsername, string adminPassword)\n    {\n        _domain = domain;\n        _adminUsername = adminUsername;\n        _adminPassword = adminPassword;\n    }\n\n    public void PerformAdminOperation()\n    {\n        using (new Impersonator(_domain, _adminUsername, _adminPassword))\n        {\n            // Code that requires impersonation\n        }\n    }\n}