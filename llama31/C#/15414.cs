public class PdfHandler : IHttpHandler\n{\n  public void ProcessRequest(HttpContext context)\n  {\n    if (!context.User.Identity.IsAuthenticated)\n    {\n      context.Response.StatusCode = 401;\n      context.Response.End();\n      return;\n    }\n\n    // serve the pdf file\n    string filePath = context.Server.MapPath("mydoc.pdf");\n    context.Response.TransmitFile(filePath);\n  }\n\n  public bool IsReusable\n  {\n    get { return true; }\n  }\n}