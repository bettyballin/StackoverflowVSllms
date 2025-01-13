public class CustomPrincipal : IPrincipal\n{\n    private readonly IIdentity _identity;\n\n    public CustomPrincipal(IIdentity identity)\n    {\n        _identity = identity;\n    }\n\n    public IIdentity Identity => _identity;\n\n    public bool IsInRole(string role)\n    {\n        // Implement role logic if needed\n        return false;\n    }\n}