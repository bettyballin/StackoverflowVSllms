Imports System.Xml\nImports System.Xml.Xsl\n\nSub TransformXml()\n    Dim xmlDoc As New XmlDocument()\n    ' Assume xmlContent is your XML content as string\n    Dim xmlContent As String = "<root/>"\n    xmlDoc.LoadXml(xmlContent)\n\n    Dim xsltDoc As New XslCompiledTransform()\n    ' Load your XSLT file or document here\n    xsltDoc.Load("your-xslt-file.xslt")\n\n    Using writer As XmlTextWriter = New XmlTextWriter(Console.Out)\n        xsltDoc.Transform(xmlDoc, Nothing, writer)\n    End Using\nEnd Sub