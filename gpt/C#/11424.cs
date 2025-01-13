public class AuthHeader : SoapHeader\n{\n    public string Username;\n    public string Password;\n}\n\n[WebService]\npublic class MyWebService : System.Web.Services.WebService\n{\n    public AuthHeader authHeader;\n\n    [WebMethod]\n    [SoapHeader("authHeader")]\n    public string GetData()\n    {\n        if (authHeader == null || !AuthenticateUser(authHeader.Username, authHeader.Password))\n        {\n            throw new SoapException("Unauthorized", SoapException.ClientFaultCode);\n        }\n        // Your logic to get data\n        return "some data";\n    }\n\n    private bool AuthenticateUser(string username, string password)\n    {\n        // Implement your authentication logic here\n        return (username == "user" && password == "pass");\n    }\n}