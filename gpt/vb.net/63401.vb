Dim resp As cResponseMessage\nDim sr As New StringReader(data)\nDim xs As New XmlReaderSettings()\n\n' Define the namespace used in the XML\nDim namespaces As New XmlSerializerNamespaces()\nnamespaces.Add(String.Empty, "http://www.w3.org/1999/xml")\n\nDim xd As New XmlSerializer(GetType(cResponseMessage))\n\nUsing reader As XmlReader = XmlReader.Create(sr, xs)\n    resp = CType(xd.Deserialize(reader), cResponseMessage)\nEnd Using