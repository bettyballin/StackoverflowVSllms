using System;\nusing System.Web;\n\npublic class SplashImageHandler : IHttpHandler\n{\n    public void ProcessRequest(HttpContext context)\n    {\n        context.Response.ContentType = "image/jpeg";\n        // download and return the splash image\n    }\n\n    public bool IsReusable\n    {\n        get { return true; }\n    }\n}