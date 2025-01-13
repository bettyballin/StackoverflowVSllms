var binding = new CustomBinding();\n   var textEncoding = new TextMessageEncodingBindingElement(MessageVersion.Soap11, Encoding.GetEncoding("iso-8859-1"));\n   var httpTransport = new HttpTransportBindingElement();\n   binding.Elements.Add(textEncoding);\n   binding.Elements.Add(httpTransport);\n\n   var endpointAddress = new EndpointAddress("http://www.flash-db.com/services/ws/siteInspect.wsdl");\n   var soapClient = new SiteInspect.SiteInspectPortClient(binding, endpointAddress);\n\n   var response = soapClient.doSiteInspect("Any", "Any", "www.google.com");\n   Assert.IsTrue(response.serverTime.Length > 0);