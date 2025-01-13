using System.Xml.Serialization;\n\npublic TestQueryResponseMessage TestQuery(TestQueryRequestMessage message)\n{\n    var xmlDoc = new XmlDocument();\n    var root = xmlDoc.CreateElement("params");\n    xmlDoc.AppendChild(root);\n\n    var paramElement = xmlDoc.CreateElement("TestParameter");\n    paramElement.InnerText = message.Body.TestParameter;\n    root.AppendChild(paramElement);\n\n    var xml = xmlDoc.OuterXml;\n\n    var result = Repository.ExecuteQuery("TestQuery", xml);\n\n    return new TestQueryResponseMessage\n    {\n        Body = new TestQueryResponse\n        {\n            TopicItems = result;\n        }\n    }\n}