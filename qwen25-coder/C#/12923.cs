using System;\nusing System.Net;\nusing System.Web.Mvc;\n\npublic class ClientCertificateRequiredAttribute : AuthorizeAttribute\n{\n    protected override bool AuthorizeCore(HttpContextBase httpContext)\n    {\n        if (httpContext == null) throw new ArgumentNullException("httpContext");\n\n        // Check if the client certificate is present\n        var certificate = httpContext.Request.ClientCertificate;\n        return !string.IsNullOrEmpty(certificate.Subject);\n    }\n\n    public override void OnAuthorization(AuthorizationContext filterContext)\n    {\n        base.OnAuthorization(filterContext);\n\n        if (!filterContext.HttpContext.User.Identity.IsAuthenticated || !filterContext.ActionDescriptor.GetCustomAttributes(typeof(ClientCertificateRequiredAttribute), false).Length.Equals(0))\n        {\n            // Respond with 401 to challenge the client for a certificate\n            var response = filterContext.HttpContext.Response;\n            response.ClearContent();\n            response.StatusCode = (int)HttpStatusCode.Unauthorized;\n            response.StatusDescription = "Client Certificate Required";\n            response.End();\n        }\n    }\n}