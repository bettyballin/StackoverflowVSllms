public class DownloadFile : IHttpHandler, System.Web.SessionState.IRequiresSessionState\n{\n\n    public void ProcessRequest (HttpContext context) {\n    //Validate user is authenticiated and authorized.\n    if (context.Request.IsAuthenticated)\n    {\n         //This is your own custom authorization mechanism\n         if (AuthorizeUser(context.Request.User))\n         {\n            //not sure what the correct content type is. This is probally wrong\n            context.Response.ContentType = "application/xls";\n            //Setting size is optional               \n            context.Response.AddHeader("Content-Disposition",\n               "attachment; filename=" + downloadName + "; size=" +               myExcellFile.Length.ToString());\n            context.Response.BinaryWrite(myExcellFile);\n\n\n         }\n\n    }