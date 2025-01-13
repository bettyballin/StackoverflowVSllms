// Database tables\npublic class Role\n{\n    public int Id { get; set; }\n    public string Name { get; set; }\n    public string Permissions { get; set; } // comma-separated list of permissions\n}\n\npublic class UserRole\n{\n    public int UserId { get; set; }\n    public int RoleId { get; set; }\n}\n\n// ASP.NET Identity configuration\npublic class Startup\n{\n    public void Configure(IApplicationBuilder app, IWebHostEnvironment env)\n    {\n        // ...\n        app.UseAuthentication();\n        app.UseAuthorization();\n        // ...\n    }\n}\n\n// Claims-based authorization\npublic class CustomAuthorizeAttribute : AuthorizeAttribute\n{\n    protected override bool AuthorizeCore(HttpContextBase httpContext)\n    {\n        var user = httpContext.User;\n        var permission = Permission.GetPermissionForAction(httpContext.Request.RequestContext.RouteData.Values["action"].ToString());\n        if (!user.HasClaim("permissions", permission))\n        {\n            return false;\n        }\n        return true;\n    }\n}\n\n// Usage\n[CustomAuthorize]\npublic class MyController : Controller\n{\n    public ActionResult MyAction()\n    {\n        // Only accessible if user has the required permission\n        return View();\n    }\n}