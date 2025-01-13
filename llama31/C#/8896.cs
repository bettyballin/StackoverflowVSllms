public static class HtmlExtensions\n{\n    public static MvcForm BeginSecureForm(this HtmlHelper htmlHelper, string actionName, string controllerName, FormMethod method, IDictionary<string, object> htmlAttributes)\n    {\n        var token = Guid.NewGuid().ToString("N");\n        var cookie = new HttpCookie("XsrfToken", token);\n\n        htmlHelper.ViewContext.HttpContext.Response.Cookies.Add(cookie);\n\n        var form = htmlHelper.BeginForm(actionName, controllerName, method, htmlAttributes);\n        form.InnerHtml += htmlHelper.Hidden("XsrfToken", token);\n\n        return form;\n    }\n}