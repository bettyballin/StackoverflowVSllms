[AttributeUsage(AttributeTargets.Method, AllowMultiple = false, Inherited = false)]\npublic class ValidateXsrfTokenAttribute : ActionFilterAttribute\n{\n    public override void OnActionExecuting(ActionExecutingContext filterContext)\n    {\n        var request = filterContext.HttpContext.Request;\n        var cookie = request.Cookies["XsrfToken"];\n        var formField = request.Form["XsrfToken"];\n\n        if (cookie == null || formField == null || cookie.Value != formField)\n        {\n            filterContext.Result = new HttpUnauthorizedResult();\n        }\n    }\n}