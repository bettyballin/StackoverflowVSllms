using System.Web.Mvc;\nusing System.Web.Routing;\n\npublic class UrlHelperExample\n{\n    public string GetResetPasswordUrl(Controller controller)\n    {\n        // Get the RequestContext from the controller\n        RequestContext requestContext = controller.ControllerContext.RequestContext;\n\n        // Create an instance of UrlHelper\n        UrlHelper urlHelper = new UrlHelper(requestContext);\n\n        // Generate the URL for the ResetPassword action in AccountController\n        string url = urlHelper.Action("ResetPassword", "Account");\n\n        return url;\n    }\n}