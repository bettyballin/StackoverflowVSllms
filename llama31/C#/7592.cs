public class CustomSoapExtension : SoapExtension\n{\n    public override object GetInitializer(Type serviceType)\n    {\n        return null;\n    }\n\n    public override object GetInitializer(LogicalMethodInfo methodInfo, SoapExtensionAttribute attribute)\n    {\n        return null;\n    }\n\n    public override void Initialize(object initializer)\n    {\n    }\n\n    public override void ProcessMessage(SoapMessage message)\n    {\n        if (message.Stage == SoapMessageStage.BeforeDeserialize)\n        {\n            // Get the SOAP response\n            var response = message.GetReader().ReadOuterXml();\n\n            // Parse the response manually\n            var xmlDoc = new XmlDocument();\n            xmlDoc.LoadXml(response);\n\n            // Handle the parsing error\n            if (xmlDoc.HasErrors)\n            {\n                // You can either fix the error or throw a custom exception\n                // For demonstration purposes, I'll just fix a simple error\n                if (xmlDoc.Errors.Count == 1 && xmlDoc.Errors[0].Severity == XmlSeverityType.Warning)\n                {\n                    xmlDoc.Errors.Clear();\n                }\n                else\n                {\n                    throw new Exception("Failed to parse SOAP response");\n                }\n            }\n\n            // Create a new SoapMessage with the parsed XmlDocument\n            var newMessage = new SoapMessage(message.MethodInfo, message.Url, xmlDoc.OuterXml);\n\n            // Replace the original message with the new one\n            message = newMessage;\n        }\n    }\n}