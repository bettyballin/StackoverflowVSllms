Imports System.Xml\n\nPartial Public Class MainPage\n    Inherits UserControl\n\n    Public Sub New()\n        InitializeComponent()\n        CreateXmlDocument()\n    End Sub\n\n    Private Sub CreateXmlDocument()\n        ' Create a new XmlWriterSettings object.\n        Dim settings As New XmlWriterSettings()\n        settings.Indent = True ' Indent the document for readability.\n\n        ' Use XmlWriter to create an XML file.\n        Using writer As XmlWriter = XmlWriter.Create("example.xml", settings)\n            writer.WriteStartDocument()  ' Start of the document\n            writer.WriteStartElement("Root") ' Root element\n\n            ' Child element with some attributes\n            writer.WriteStartElement("Child")\n            writer.WriteAttributeString("attribute1", "value1")\n            writer.WriteEndElement()\n\n           writer.WriteEndElement()  ' End of the Root element\n            writer.WriteEndDocument() ' End of the document\n        End Using\n    End Sub\nEnd Class