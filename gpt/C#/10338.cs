public class DynamicImageHandler : IHttpHandler, IRequiresSessionState\n{\n    public void ProcessRequest(HttpContext context)\n    {\n        // Your code to generate and serve the image\n    }\n\n    public bool IsReusable\n    {\n        get { return false; }\n    }\n}