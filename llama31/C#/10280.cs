using System;\nusing System.Web;\nusing System.Web.Security;\nusing System.Data;\nusing System.Data.SqlClient;\nusing System.Web.Script.Serialization;\n\npublic class AjaxHandler : IHttpHandler\n{\n    public void ProcessRequest(HttpContext context)\n    {\n        string action = context.Request["action"];\n        string id = context.Request["id"];\n\n        // Authenticate and authorize the request\n        if (!HttpContext.Current.User.Identity.IsAuthenticated)\n        {\n            context.Response.StatusCode = 401;\n            context.Response.StatusDescription = "Unauthorized";\n            return;\n        }\n\n        try\n        {\n            switch (action)\n            {\n                case "insert":\n                    // Insert logic here\n                    break;\n                case "update":\n                    // Update logic here\n                    break;\n                case "delete":\n                    // Delete logic here\n                    break;\n                default:\n                    context.Response.StatusCode = 400;\n                    context.Response.StatusDescription = "Invalid action";\n                    return;\n            }\n\n            // Return JSON data\n            JavaScriptSerializer serializer = new JavaScriptSerializer();\n            string jsonData = serializer.Serialize(new { success = true });\n            context.Response.ContentType = "application/json";\n            context.Response.Write(jsonData);\n        }\n        catch (Exception ex)\n        {\n            // Handle exceptions and errors\n            context.Response.StatusCode = 500;\n            context.Response.StatusDescription = "Internal Server Error";\n            context.Response.Write("Error: " + ex.Message);\n        }\n    }\n\n    public bool IsReusable { get { return true; } }\n}