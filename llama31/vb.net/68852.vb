Imports System.Net\n\nPublic Function GetValueFromASHX() As String\n    Dim request As WebRequest = WebRequest.Create("http://yourdomain.com/yourashxhandler.ashx")\n    Dim response As WebResponse = request.GetResponse()\n    Dim reader As New StreamReader(response.GetResponseStream())\n    Dim result As String = reader.ReadToEnd()\n    reader.Close()\n    response.Close()\n    Return result\nEnd Functio