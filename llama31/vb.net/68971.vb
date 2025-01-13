Imports System.Net\nImports System.IO\n\nPrivate Sub DownloadImage()\n    Dim url As String = "https://example.com/image.png" ' replace with your URL\n    Dim request As WebRequest = WebRequest.Create(url)\n    Dim response As WebResponse = request.GetResponse()\n\n    Using stream As Stream = response.GetResponseStream()\n        Dim image As Image = Image.FromStream(stream)\n        PictureBox1.Image = image ' replace PictureBox1 with your PictureBox control\n    End Using\nEnd Sub