using System.IdentityModel.Policy;\nusing System.Collections.ObjectModel;\n\npublic class CustomAuthorizationPolicy : IAuthorizationPolicy\n{\n    private readonly ClaimsPrincipal _principal;\n\n    public CustomAuthorizationPolicy(ClaimsPrincipal principal)\n    {\n        this._principal = principal;\n    }\n\n    public string Id => Guid.NewGuid().ToString();\n\n    public ClaimSet Issuer => ClaimSet.System;\n\n    public bool Evaluate(EvaluationContext evaluationContext, ref object state)\n    {\n        // Add the Windows Identity to the Authorization Context\n        evaluationContext.Properties["Principal"] = _principal;\n        \n        return true;\n    }\n}