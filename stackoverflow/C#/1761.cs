public class AjaxAuthorizeAttribute : AuthorizeAttribute {\n    override public void OnAuthorization(AuthorizationContext filterContext) {\n        base.OnAuthorization(filterContext);\n        // Only do something if we are about to give a HttpUnauthorizedResult and we are in AJAX mode.\n        if (filterContext.Result is HttpUnauthorizedResult && filterContext.HttpContext.Request.IsAjaxRequest()) {\n            // TODO: fix the URL building:\n            // 1- Use some class to build URLs just in case LoginUrl actually has some query already.\n            // 2- When leaving Result as a HttpUnauthorizedResult, ASP.Net actually does some nice automatic stuff, like adding a ReturnURL, when hardcodding the URL here, that is lost.\n            String url = System.Web.Security.FormsAuthentication.LoginUrl + "?X-Requested-With=XMLHttpRequest";\n            filterContext.Result = new RedirectResult(url);\n        }\n    }\n}