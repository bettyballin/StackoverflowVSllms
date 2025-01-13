public void ProcessRequest(HttpContext context)\n{\n    // Clear any previous output or headers\n    context.Response.Clear();\n    \n    // Set necessary headers for file download\n    context.Response.ContentType = "application/octet-stream";\n    context.Response.AddHeader("Content-Disposition", "attachment; filename=ChartImages.zip");\n    context.Response.BufferOutput = false;\n\n    // Disable caching to ensure the file is not cached\n    context.Response.Cache.SetCacheability(HttpCacheability.NoCache);\n    context.Response.Cache.SetExpires(DateTime.UtcNow.AddDays(-1));\n    context.Response.Cache.SetValidUntilExpires(false);\n\n    try\n    {\n        using (ZipFile zip = new ZipFile())\n        {\n            // Add files to zip as needed\n            zip.AddFile(context.Server.MapPath("sample1.png"));\n            \n            // Save the zip directly to the response output stream\n            zip.Save(Response.OutputStream);\n        }\n        \n        // Ensure the request is completed and further processing stops\n        context.ApplicationInstance.CompleteRequest();\n    }\n    catch (Exception ex)\n    {\n        // Handle any exceptions that may occur during file generation or streaming\n        context.Response.StatusCode = 500;\n        context.Response.Write("Error generating file: " + ex.Message);\n    }\n}