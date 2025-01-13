using System;\nusing System.Web;\n\npublic class IPAccessModule : IHttpModule\n{\n    private static readonly string[] AllowedIPAddresses = { "192.168.100.1", "192.168.100.2" };\n\n    public void Init(HttpApplication context)\n    {\n        context.AuthenticateRequest += new EventHandler(OnAuthenticateRequest);\n    }\n\n    public void OnAuthenticateRequest(object sender, EventArgs e)\n    {\n        HttpContext ctx = HttpContext.Current;\n        string ipAddress = ctx.Request.UserHostAddress;\n\n        if (!IsAllowedIP(ipAddress))\n        {\n            ctx.Response.StatusCode = 403; // Forbidden\n            ctx.Response.End();\n        }\n    }\n\n    private bool IsAllowedIP(string ipAddress)\n    {\n        foreach (string allowedIP in AllowedIPAddresses)\n        {\n            if (allowedIP.Equals(ipAddress, StringComparison.OrdinalIgnoreCase))\n                return true;\n        }\n        return false;\n    }\n\n    public void Dispose() { }\n}