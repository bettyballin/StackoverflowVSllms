Dim ms As MemoryStream = DecryptFile(m_TheXMLDatasetPath, sKey)\nms.Position = 0\nds.ReadXmlSchema(m_TheSchemaPath)\nds.ReadXml(ms, XmlReadMode.IgnoreSchema)