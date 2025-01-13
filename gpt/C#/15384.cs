using System.Web;\n   using System.Web.Services;\n   using System.Web.Script.Serialization;\n   \n   [WebService(Namespace = "http://tempuri.org/")]\n   [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]\n   [System.ComponentModel.ToolboxItem(false)]\n   public class MyWebService : WebService\n   {\n       [WebMethod]\n       [ScriptMethod(ResponseFormat = ResponseFormat.Json)]\n       public void GetJsonData()\n       {\n           Context.Response.Clear();\n           Context.Response.ContentType = "application/json";\n   \n           var data = new { Name = "John Doe", Age = 30 };\n   \n           JavaScriptSerializer jsSerializer = new JavaScriptSerializer();\n           string jsonData = jsSerializer.Serialize(data);\n   \n           Context.Response.Write(jsonData);\n           Context.Response.End();\n       }\n   \n       [WebMethod]\n       public string EchoJsonData(string jsonData)\n       {\n           JavaScriptSerializer jsSerializer = new JavaScriptSerializer();\n           var data = jsSerializer.Deserialize<Dictionary<string, object>>(jsonData);\n   \n           // Optionally modify the data\n   \n           return jsSerializer.Serialize(data);\n       }\n   }