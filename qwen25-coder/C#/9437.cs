using System.Web.Services;\n\npublic partial class Default : System.Web.UI.Page\n{\n    [WebMethod]\n    public static string MyServerSideMethod(string param1, string param2)\n    {\n        return "Result: " + param1 + " " + param2;\n    }\n}