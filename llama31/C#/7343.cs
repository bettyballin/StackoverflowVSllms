public class ImageHandler : IHttpHandler\n{\n    public void ProcessRequest(HttpContext context)\n    {\n        // Handle image requests here\n    }\n\n    public bool IsReusable\n    {\n        get { return true; }\n    }\n}