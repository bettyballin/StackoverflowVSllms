Imports System.Net\n\nPublic Class Form1\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' URL of the PNG image\n        Dim imageUrl As String = "https://example.com/image.png"\n\n        ' Create a WebClient to download the image\n        Using client As New WebClient()\n            ' Download the image as a byte array\n            Dim imageBytes() As Byte = client.DownloadData(imageUrl)\n            \n            ' Convert the byte array to an image\n            Using ms As New IO.MemoryStream(imageBytes)\n                Dim image As Image = Image.FromStream(ms)\n                \n                ' Set the PictureBox's Image property to the downloaded image\n                PictureBox1.Image = image\n            End Using\n        End Using\n    End Sub\nEnd Class