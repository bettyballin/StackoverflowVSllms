protected void Page_Load(object sender, EventArgs e)\n{\n    Response.Clear();\n    Response.ContentType = "text/xml";\n    using (XmlTextWriter writer = new XmlTextWriter(Response.OutputStream, Encoding.UTF8))\n    {\n        writer.WriteStartDocument();\n        writer.WriteStartElement("rows");\n        writer.WriteElementString("page", "1");\n        writer.WriteElementString("total", "25");\n        writer.WriteElementString("records", "3");\n        for (int i = 1; i <= 3; i++)\n        {\n            writer.WriteStartElement("row");\n            writer.WriteAttributeString("id", i.ToString());\n            writer.WriteElementString("cell", "Row " + i + ", Column 1");\n            writer.WriteElementString("cell", "Row " + i + ", Column 2");\n            writer.WriteElementString("cell", "Row " + i + ", Column 3");\n            writer.WriteEndElement();\n        }\n        writer.WriteEndElement();\n        writer.WriteEndDocument();\n    }\n    Response.End();\n}