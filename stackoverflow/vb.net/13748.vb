Imports Common\nImports System.IO\nImports System.Net\n\nPublic Class LiveCam\n    Implements IHttpHandler\n\n    Private ReadOnly URL As String = "http://12.34.56.78/snapshot.cgi"\n    Private ReadOnly FAIL As String = Common.MapPath("~/i/cam-oos.jpg")        \n\n    Public Sub ProcessRequest(ByVal context As System.Web.HttpContext) Implements System.Web.IHttpHandler.ProcessRequest\n        Dim Data As Byte()\n\n        With context.Response\n           .ContentEncoding = Encoding.UTF8\n           .ContentType = "text/plain"\n           .Write("data:image/png;base64,")\n\n           Try\n               Using Client As New WebClient()\n                   Data = Client.DownloadData(URL)\n               End Using\n           Catch ex As WebException\n               Data = File.ReadAllBytes(FAIL)\n           End Try\n\n           .Write(Convert.ToBase64String(Data))\n        End With\n    End Sub\nEnd Class