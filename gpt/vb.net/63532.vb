Imports System.Xml\nImports System.Xml.Schema\n\nPublic Function ValidateXML(ByVal strXML As String, ByVal schemaPath As String) As Boolean\n    Dim isValid As Boolean = True\n\n    ' Create an XmlReaderSettings object\n    Dim settings As XmlReaderSettings = New XmlReaderSettings()\n    \n    ' Add the schema to the settings\n    settings.Schemas.Add(Nothing, schemaPath)\n    settings.ValidationType = ValidationType.Schema\n\n    ' Set the validation event handler\n    AddHandler settings.ValidationEventHandler, Sub(sender As Object, e As ValidationEventArgs)\n                                                    isValid = False\n                                                    Console.WriteLine("Validation Error: " & e.Message)\n                                                End Sub\n\n    ' Create an XmlReader with the settings\n    Using reader As XmlReader = XmlReader.Create(New System.IO.StringReader(strXML), settings)\n        Try\n            ' Parse the XML file\n            While reader.Read()\n                ' No operation is needed here, the reading process will trigger validation\n            End While\n        Catch ex As Exception\n            isValid = False\n            Console.WriteLine("Exception: " & ex.Message)\n        End Try\n    End Using\n\n    Return isValid\nEnd Functio