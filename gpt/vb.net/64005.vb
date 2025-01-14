Try\n    ' Ensure the Response is still available and not null\n    If Not IsNothing(Me.Context) AndAlso Not IsNothing(Me.Context.Response) AndAlso Not IsNothing(Me.Context.Response.OutputStream) Then\n        Dim XMLWriter As New System.Xml.XmlTextWriter(Me.Context.Response.OutputStream, Encoding.UTF8)\n        XMLWriter.WriteStartDocument()\n        XMLWriter.WriteStartElement("Status")\n\n        Message.SerializeToXML(XMLWriter)\n\n        XMLWriter.WriteEndElement()\n        XMLWriter.WriteEndDocument()\n        XMLWriter.Flush()\n        XMLWriter.Close()\n    Else\n        ' Handle the case where the response or output stream is not available\n        ' Log or take appropriate action\n    End If\nCatch ex As ObjectDisposedException\n    ' Handle the case where the stream has been disposed, likely due to a client disconnect\n    ' Log the exception or take appropriate action\nCatch ex As NullReferenceException\n    ' Handle the null reference exception\n    ' Log the exception or take appropriate action\nCatch ex As Exception\n    ' Handle any other exceptions that may occur\n    ' Log the exception or take appropriate action\nEnd Try