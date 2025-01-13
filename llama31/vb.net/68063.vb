Try\n    Dim myWebResponse As WebResponse = request.GetResponse()\n    ' Handle success\n    Dim myResponseStream As Stream = myWebResponse.GetResponseStream()\n    Dim myStreamReader As StreamReader = New StreamReader(myResponseStream)\n    Dim msg As String = myStreamReader.ReadToEnd()\n    myStreamReader.Close()\n    myResponseStream.Close()\nCatch ex As WebException\n    ' Handle error\n    Dim msg As String = ex.Message\n    ' Do something with the error message\nEnd Try