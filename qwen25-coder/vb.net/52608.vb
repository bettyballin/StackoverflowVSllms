Imports System.Xml\n\nModule Module1\n    Sub Main()\n        ' Path to your XML file\n        Dim xmlFilePath As String = "path_to_your_xml_file.xml"\n\n        Using reader As XmlReader = XmlReader.Create(xmlFilePath)\n            While reader.Read()\n                If reader.NodeType = XmlNodeType.Element Then\n                    Console.WriteLine("Element: {0}", reader.Name)\n                End If\n                If reader.HasValue Then\n                    Console.WriteLine("Value: {0}", reader.Value)\n                End If\n            End While\n        End Using\n    End Sub\nEnd Module