public async Task CheckConnectionAsync(HttpContext context)\n{\n    context.Response.Write(' ');\n    await context.Response.FlushAsync();\n\n    if (!context.Response.IsClientConnected)\n    {\n        // Handle disconnected client\n    }\n}