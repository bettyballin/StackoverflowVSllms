public void ProcessRequest(HttpContext context)\n{\n    try\n    {\n        // Your logic for creating a user\n        var isSuccess = CreateUser(context.Request["u"], context.Request["p"], context.Request["e"]);\n        \n        if (isSuccess)\n            context.Response.StatusCode = 200; // Success\n        else\n            throw new Exception("User creation failed.");\n    }\n    catch (Exception ex)\n    {\n        context.Response.StatusCode = 409; // Conflict, or any other relevant status code\n        var errorResponse = new { message = "An error occurred: " + ex.Message };\n        context.Response.Write(JsonConvert.SerializeObject(errorResponse));\n    }\n}