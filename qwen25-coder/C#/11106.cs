using System;\nusing System.Web.Services.Protocols;\n\nnamespace Whatever\n{\n    public class WebServiceInvoker : SoapHttpClientProtocol\n    {\n        public string BindingName { get; private set; }\n        public string NamespaceUri { get; private set; }\n\n        public WebServiceInvoker(string url, string ns, string bindingName)\n        {\n            Url = url;\n            NamespaceUri = ns;\n            BindingName = bindingName;\n\n            // You can set credentials here if needed\n        }\n\n        public object[] MakeInvoke(string method, object[] args)\n        {\n            return Invoke(method, args);\n        }\n\n        public TRet InvokeFunction<TRet>(string method, params object[] args)\n        {\n            var res = Invoke(method, args);\n            return (TRet)res;\n        }\n\n        protected override string GetPath()\n        {\n            // You can customize the path if needed\n            return base.GetPath();\n        }\n\n        protected override WebRequest CreateWebRequest(UrlBuilder urlBuilder, WebServiceMethod methodInfo)\n        {\n            var request = base.CreateWebRequest(urlBuilder, methodInfo);\n\n            // Customize SOAP action header to include namespace and binding name if necessary\n            request.Headers["SOAPAction"] = $"{NamespaceUri}/{methodInfo.Action}";\n\n            return request;\n        }\n    }\n\n    public class Entity { } // Example entity class\n}\n\n// Usage example:\n// var miProxy = new WebServiceInvoker("http://webServiceLocation", "ns", "Binding");\n// var res = miProxy.InvokeFunction<string, string, Entity>("MyWebMethod", "stringPar1", "stringPar2");