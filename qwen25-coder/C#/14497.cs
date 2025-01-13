protected void Application_Error()\n{\n    var exception = Server.GetLastError();\n    \n    if (exception is HttpRequestValidationException)\n    {\n        // Log the exception or do something else with it\n        Logger.Log(exception);\n\n        // Clear the error from the server\n        Server.ClearError();\n\n        // Redirect to a friendly error page, or render a view\n        Response.Redirect("/Home/Error");\n        \n        // Alternatively, you can just render a different view:\n        // var routeData = new RouteData();\n        // routeData.Values["controller"] = "Error";\n        // routeData.Values["action"] = "Index";\n        // Server.ClearError();\n        // IController controller = new ErrorController();\n        // controller.Execute(new RequestContext(new HttpContextWrapper(Context), routeData));\n    }\n}