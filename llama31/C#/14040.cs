public static bool IsAjaxRequest(this HttpRequest request)\n{\n    return request.Headers["X-Requested-With"] == "XMLHttpRequest";\n}