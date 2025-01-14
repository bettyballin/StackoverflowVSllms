Public Shared Function SendTextMessage(ByVal username As String, ByVal txt As String) As String\n    Dim content As String = "user_id=" + username + "&body=" + HttpUtility.UrlEncode(txt)\n    Dim httpDate As String = DateTime.Now.ToString("r")\n    Dim canonicalString As String = API_KEY & httpDate & content\n\n    Dim encoding As New System.Text.UTF8Encoding()\n    Dim hmacSha As New HMACSHA1(encoding.GetBytes(SECRET_ACCESS_KEY))\n\n    Dim hash() As Byte = hmacSha.ComputeHash(encoding.GetBytes(canonicalString))\n    Dim b64 As String = Convert.ToBase64String(hash)\n\n    'connect with zeep'\n    Dim request As HttpWebRequest = CType(WebRequest.Create("https://api.zeepmobile.com/messaging/2008-07-14/send_message"), HttpWebRequest)\n    request.Method = "POST"\n    request.ServicePoint.Expect100Continue = False\n\n    ' set the authorization levels'\n    request.Headers.Add("Authorization", "Zeep " & API_KEY & ":" & b64)\n    request.ContentType = "application/x-www-form-urlencoded"\n    request.ContentLength = content.Length\n\n    ' set up and write to stream'\n    Using reqStream As New StreamWriter(request.GetRequestStream())\n        reqStream.Write(content)\n    End Using\n\n    Dim responseMessage As String = String.Empty\n\n    Try\n        Using myWebResponse As WebResponse = request.GetResponse()\n            Using myResponseStream As Stream = myWebResponse.GetResponseStream()\n                Using myStreamReader As New StreamReader(myResponseStream)\n                    responseMessage = myStreamReader.ReadToEnd()\n                End Using\n            End Using\n        End Using\n    Catch ex As WebException\n        If ex.Response IsNot Nothing Then\n            Using errorResponse As WebResponse = ex.Response\n                Using errorStream As Stream = errorResponse.GetResponseStream()\n                    Using reader As New StreamReader(errorStream)\n                        responseMessage = reader.ReadToEnd()\n                    End Using\n                End Using\n            End Using\n        Else\n            responseMessage = ex.Message\n        End If\n    End Try\n\n    Return responseMessage\nEnd Functio