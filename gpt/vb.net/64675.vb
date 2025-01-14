Dim oHttpWebRequest As System.Net.HttpWebRequest = CType(System.Net.WebRequest.Create("http://somesite/foo.jsp"), System.Net.HttpWebRequest)\noHttpWebRequest.Method = "GET"\noHttpWebRequest.ContentType = "application/x-www-form-urlencoded"\noHttpWebRequest.UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36"\n\nTry\n    Dim oHttpWebResponse As System.Net.HttpWebResponse = CType(oHttpWebRequest.GetResponse(), System.Net.HttpWebResponse)\n    Dim oStream As System.IO.Stream = oHttpWebResponse.GetResponseStream()\n    Dim sChunk As String = New System.IO.StreamReader(oStream).ReadToEnd()\n    oStream.Close()\n    oHttpWebResponse.Close()\n    ' Process sChunk as needed, e.g., parse the HTML to extract the data table\nCatch ex As System.Net.WebException\n    ' Handle the error, e.g., log it or rethrow\n    Console.WriteLine("WebException: " & ex.Message)\n    If ex.Response IsNot Nothing Then\n        Using responseStream = ex.Response.GetResponseStream()\n            Using reader As New System.IO.StreamReader(responseStream)\n                Dim errorText As String = reader.ReadToEnd()\n                Console.WriteLine("Response: " & errorText)\n            End Using\n        End Using\n    End If\nCatch ex As Exception\n    ' Handle other possible exceptions\n    Console.WriteLine("Exception: " & ex.Message)\nEnd Try