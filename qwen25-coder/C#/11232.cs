using System.Web.Mvc;\nusing System.Web.Routing;\n\npublic static string GetResetPasswordUrl(RequestContext requestContext)\n{\n    var urlHelper = new UrlHelper(requestContext);\n    return urlHelper.Action("ResetPassword", "Account");\n}