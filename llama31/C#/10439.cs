[AttributeUsage(AttributeTargets.Class | AttributeTargets.Method, Inherited = true, AllowMultiple = false)]\npublic class SuppressFormsAuthenticationRedirectAttribute : AuthorizeAttribute\n{\n    protected override bool AuthorizeCore(HttpContextBase httpContext)\n    {\n        bool authorized = base.AuthorizeCore(httpContext);\n        if (!authorized)\n        {\n            httpContext.Response.SuppressFormsAuthenticationRedirect = true;\n        }\n        return authorized;\n    }\n}