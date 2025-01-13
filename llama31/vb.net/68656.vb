Public Function GetPage(ByVal url As String) As String\n    Dim result As String = String.Empty\n\n    Dim uri As New Uri(url)\n    Dim request As HttpWebRequest = WebRequest.Create(uri)\n    request.KeepAlive = False\n    request.Timeout = 15000\n\n    Try\n        Using response As HttpWebResponse = DirectCast(request.GetResponse, HttpWebResponse)\n            Using dataStream As Stream = response.GetResponseStream()\n                Using reader As New StreamReader(dataStream)\n                    If response.StatusCode <> HttpStatusCode.OK Then\n                        Throw New Exception("Got response status code: " + response.StatusCode)\n                    End If\n                    result = reader.ReadToEnd()\n                End Using\n            End Using\n            response.Close()\n        End Using\n\n        ' Close the connection group\n        request.ServicePoint.CloseConnectionGroup(request.ConnectionGroupName)\n\n    Catch ex As Exception\n        Dim msg As String = "Error reading page """ & url & """. " & ex.Message\n        Logger.LogMessage(msg, LogOutputLevel.Diagnostics)\n    End Try\n\n    Return result\nEnd Functio