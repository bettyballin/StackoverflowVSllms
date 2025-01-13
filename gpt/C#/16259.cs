public static bool IsAjaxRequest(this HttpRequestBase request)\n{\n    if (request == null)\n    {\n        throw new ArgumentNullException("request");\n    }\n\n    return (request["X-Requested-With"] == "XMLHttpRequest") ||\n           (request.Headers != null && request.Headers["X-Requested-With"] == "XMLHttpRequest");\n}