[System.Web.Services.WebMethod]\n   public static void ValidateLogin()\n   {\n       AntiForgery.Validate();\n       // Login logic here...\n   }