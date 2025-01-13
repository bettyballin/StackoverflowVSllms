using System;\nusing System.Collections.Specialized;\nusing System.IO;\nusing System.ServiceModel.Channels;\nusing System.ServiceModel.Dispatcher;\nusing System.Web;\n\npublic class FormUrlEncodedMessageFormatter : IDispatchMessageFormatter\n{\n    public void DeserializeRequest(Message message, object[] parameters)\n    {\n        var request = message.Properties["httpRequest"] as HttpRequestMessageProperty;\n        string formData = new StreamReader(message.GetBody<Stream>()).ReadToEnd();\n        NameValueCollection parsedData = HttpUtility.ParseQueryString(formData);\n\n        parameters[0] = parsedData["query"];\n        parameters[1] = parsedData["params"].Split(',');\n    }\n\n    public Message SerializeReply(MessageVersion messageVersion, object[] parameters, object result)\n    {\n        throw new NotImplementedException("This method should not be called.");\n    }\n}