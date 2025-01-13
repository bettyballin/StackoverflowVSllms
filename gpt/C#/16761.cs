using System.ServiceModel.Channels;\nusing System.ServiceModel.Dispatcher;\nusing System.Xml.Linq;\n\npublic class XhtmlMessageFormatter : IDispatchMessageFormatter\n{\n    public void DeserializeRequest(Message message, object[] parameters)\n    {\n        throw new NotImplementedException("This formatter is for responses only.");\n    }\n\n    public Message SerializeReply(MessageVersion messageVersion, object[] parameters, object result)\n    {\n        var xhtmlString = result as string;\n\n        // Create an XHTML document\n        XElement xhtml = new XElement("html",\n            new XElement("head", new XElement("title", "XHTML Response")),\n            new XElement("body", new XElement("div", xhtmlString))\n        );\n\n        // Create the WCF message\n        Message replyMessage = Message.CreateMessage(messageVersion, null, new XhtmlBodyWriter(xhtml));\n        replyMessage.Properties.Add(WebBodyFormatMessageProperty.Name, new WebBodyFormatMessageProperty(WebContentFormat.Raw));\n        replyMessage.Properties.Add(HttpResponseMessageProperty.Name, new HttpResponseMessageProperty { Headers = { { "Content-Type", "application/xhtml+xml" } } });\n\n        return replyMessage;\n    }\n}\n\npublic class XhtmlBodyWriter : BodyWriter\n{\n    private XElement xhtml;\n\n    public XhtmlBodyWriter(XElement xhtml)\n        : base(true)\n    {\n        this.xhtml = xhtml;\n    }\n\n    protected override void OnWriteBodyContents(XmlDictionaryWriter writer)\n    {\n        xhtml.WriteTo(writer);\n    }\n}