Imports System.Net\n\nPublic Sub CheckForUpdate()\n    Dim updateUrl As String = "http://yourwebsite.com/slotshuffle2.0.zip"\n    Try\n        ' Create an HttpWebRequest object to the specified URI.\n        Using request As WebRequest = WebRequest.Create(updateUrl)\n            request.Method = "HEAD" ' Use HEAD method to get headers without downloading content\n\n            ' Get the response from that request\n            Using response As WebResponse = request.GetResponse()\n                If CType(response, HttpWebResponse).StatusCode = HttpStatusCode.OK Then\n                    MessageBox.Show("New version available: " & updateUrl)\n                Else\n                    MessageBox.Show("No new version check back later")\n                End If\n            End Using\n        End Using\n    Catch ex As WebException\n        ' Handle exceptions (e.g., 404 Not Found, Network Error)\n        MessageBox.Show("Failed to check for updates: " & ex.Message)\n    End Try\nEnd Sub