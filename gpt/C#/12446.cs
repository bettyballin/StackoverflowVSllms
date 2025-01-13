public class MvcApplication : System.Web.HttpApplication\n    {\n        protected void Application_Error()\n        {\n            var exception = Server.GetLastError();\n            // Log the exception\n            // ...\n\n            Response.Clear();\n\n            if (Request.IsAjaxRequest())\n            {\n                Response.ContentType = "application/json";\n                Response.Write(JsonConvert.SerializeObject(new { success = false, message = "An error occurred. Please try again later." }));\n                Response.End();\n            }\n            else\n            {\n                Response.Redirect("~/Error");\n            }\n        }\n    }