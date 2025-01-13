Imports System.Xml\nImports System.Xml.Schema\n\nPublic Function ValidateXML(ByVal strXML As String, ByVal schemaUri As String) As Boolean\n    Dim schemaSet As New XmlSchemaSet()\n    schemaSet.Add("", schemaUri)\n\n    Dim settings As New XmlReaderSettings()\n    settings.Schemas = schemaSet\n    settings.ValidationType = ValidationType.Schema\n\n    Try\n        Dim reader As XmlReader = XmlReader.Create(New StringReader(strXML), settings)\n        While reader.Read()\n        End While\n        Return True\n    Catch ex As XmlException\n        Return False\n    End Try\nEnd Functio