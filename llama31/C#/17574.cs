[AttributeUsage(AttributeTargets.Method, AllowMultiple = false, Inherited = false)]\npublic class RequiresPermissionAttribute : AuthorizeAttribute\n{\n    private readonly string _permissionName;\n\n    public RequiresPermissionAttribute(string permissionName)\n    {\n        _permissionName = permissionName;\n    }\n\n    protected override bool AuthorizeCore(HttpContextBase httpContext)\n    {\n        CustomAuthorizationManager authorizationManager = new CustomAuthorizationManager(System.Configuration.ConfigurationManager.ConnectionStrings["YourConnectionString"].ConnectionString);\n\n        return authorizationManager.Authorize(httpContext.User.Identity.Name, _permissionName);\n    }\n}