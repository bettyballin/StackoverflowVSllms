public class MyHandlerFactory : IHttpHandlerFactory\n{\n  public IHttpHandler GetHandler(HttpContext context, ........)\n  {\n     // This is saying, "if they requested this URL, use this Page class to render it"\n     if (context.Request.AppRelativeCurrentExecutionFilePath.ToUpper() == "~/WRC/TEST.ASPX")\n     {\n       return new MyProject.Code._Test();\n     }\n     else\n     {\n       //other urls can do other things\n     }\n\n  }\n  .....\n}