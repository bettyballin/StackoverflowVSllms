Private Function SerializeData(ByVal data As cData) As String\n    If data IsNot Nothing Then\n        Dim xml_stream As New MemoryStream()\n        Dim xs As New XmlSerializer(GetType(cData))\n        Dim settings As New XmlWriterSettings()\n        settings.Indent = False\n\n        Try\n            Using writer As XmlWriter = XmlWriter.Create(xml_stream, settings)\n                xs.Serialize(writer, data)\n            End Using\n\n            xml_stream.Position = 0\n            Using sr As New StreamReader(xml_stream)\n                Return sr.ReadToEnd()\n            End Using\n        Finally\n            xml_stream.Close()\n        End Try\n    Else\n        Return "No data"\n    End If\nEnd Functio