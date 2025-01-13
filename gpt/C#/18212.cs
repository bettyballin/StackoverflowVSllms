public abstract class BaseController : Controller\n{\n    protected override void OnActionExecuting(ActionExecutingContext filterContext)\n    {\n        if (filterContext.HttpContext.Request.HttpMethod == "POST")\n        {\n            string cookieToken = filterContext.HttpContext.Request.Cookies["XSRF-TOKEN"]?.Value;\n            string formToken = filterContext.HttpContext.Request.Form["XSRF-TOKEN"];\n\n            if (string.IsNullOrEmpty(cookieToken) || string.IsNullOrEmpty(formToken) || cookieToken != formToken)\n            {\n                filterContext.Result = new HttpStatusCodeResult(HttpStatusCode.Forbidden);\n                return;\n            }\n        }\n        base.OnActionExecuting(filterContext);\n    }\n}