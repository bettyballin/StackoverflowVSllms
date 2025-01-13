using System;\nusing System.Web.Mvc;\n\npublic class AdminAuthorizeAttribute : AuthorizeAttribute\n{\n    protected override bool AuthorizeCore(HttpContextBase httpContext)\n    {\n        var isAdmin = httpContext.Session["IsAdmin"] != null && (bool)httpContext.Session["IsAdmin"];\n        return isAdmin;\n    }\n\n    protected override void HandleUnauthorizedRequest(AuthorizationContext filterContext)\n    {\n        filterContext.Result = new RedirectToRouteResult(\n            new RouteValueDictionary { { "controller", "Login" }, { "action", "Index" } });\n    }\n}