using System;\nusing System.Web;\n\npublic class MyHandler : IHttpHandler\n{\n    public bool IsReusable\n    {\n        get { return true; }\n    }\n\n    public void ProcessRequest(HttpContext context)\n    {\n        // Your custom logic goes here\n    }\n}