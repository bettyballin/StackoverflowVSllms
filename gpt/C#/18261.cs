using System;\nusing System.Web.Mvc;\n\npublic class HandleHttpRequestValidationExceptionAttribute : FilterAttribute, IExceptionFilter\n{\n    public void OnException(ExceptionContext filterContext)\n    {\n        if (filterContext.Exception is HttpRequestValidationException)\n        {\n            // Mark the exception as handled\n            filterContext.ExceptionHandled = true;\n\n            // Preserve the ModelState\n            filterContext.Controller.ViewData.ModelState.AddModelError("HttpRequestValidationException", "Invalid input detected.");\n\n            // Pass the input values back to the view\n            filterContext.Result = new ViewResult\n            {\n                ViewName = filterContext.RouteData.Values["action"].ToString(),\n                ViewData = filterContext.Controller.ViewData,\n                TempData = filterContext.Controller.TempData\n            };\n\n            // Set the response status code to 400 (Bad Request)\n            filterContext.HttpContext.Response.StatusCode = 400;\n        }\n    }\n}