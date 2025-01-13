Imports System.Xml\n\nModule Module1\n    Sub Main()\n        Dim xmlString As String = "<config><string1>value1</string1><string2>value2</string2></config>"\n        Dim xmlDoc As New XmlDocument()\n        xmlDoc.LoadXml(xmlString)\n\n        For Each node As XmlNode In xmlDoc.DocumentElement.ChildNodes\n            Console.WriteLine(node.Name & " = " & node.InnerText)\n        Next\n    End Sub\nEnd Module