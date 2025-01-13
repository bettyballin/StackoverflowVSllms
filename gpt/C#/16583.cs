using System.ServiceModel;\n   using System.ServiceModel.Channels;\n   using System.ServiceModel.Dispatcher;\n   using System.ServiceModel.Description;\n   using System.Net;\n\n   public class CookieMessageInspector : IClientMessageInspector\n   {\n       private string _cookieName;\n       private string _cookieValue;\n\n       public CookieMessageInspector(string cookieName, string cookieValue)\n       {\n           _cookieName = cookieName;\n           _cookieValue = cookieValue;\n       }\n\n       public void AfterReceiveReply(ref Message reply, object correlationState)\n       {\n           // Not needed for this example\n       }\n\n       public object BeforeSendRequest(ref Message request, IClientChannel channel)\n       {\n           HttpRequestMessageProperty httpRequest;\n           if (request.Properties.ContainsKey(HttpRequestMessageProperty.Name))\n           {\n               httpRequest = (HttpRequestMessageProperty)request.Properties[HttpRequestMessageProperty.Name];\n           }\n           else\n           {\n               httpRequest = new HttpRequestMessageProperty();\n               request.Properties.Add(HttpRequestMessageProperty.Name, httpRequest);\n           }\n\n           string cookieHeader = $"{_cookieName}={_cookieValue}";\n           httpRequest.Headers[HttpRequestHeader.Cookie] = cookieHeader;\n\n           return null;\n       }\n   }