using System.Web;\n\npublic class CustomHttpHandler : IHttpHandler, IRequiresSessionState\n{\n    public void ProcessRequest(HttpContext context)\n    {\n        // Your handler logic here\n    }\n\n    public bool IsReusable\n    {\n        get { return false; }\n    }\n}