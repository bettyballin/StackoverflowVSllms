using System.Web.Services;\n\n[WebService(Namespace = "http://tempuri.org/")]\n[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\npublic class YourWebService : WebService\n{\n    [WebMethod]\n    public string YourMethod()\n    {\n        return "Hello, world!";\n    }\n}