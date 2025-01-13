Imports System.Net\n\nPublic Class Form1\n    Private WithEvents PictureBox1 As New PictureBox\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        Dim imageUrl As String = "https://example.com/image.jpg"\n        Dim imageRequest As HttpWebRequest = WebRequest.Create(imageUrl)\n        Dim imageResponse As HttpWebResponse = imageRequest.GetResponse()\n        Dim imageStream As Stream = imageResponse.GetResponseStream()\n\n        PictureBox1.Image = New Bitmap(imageStream)\n        PictureBox1.SizeMode = PictureBoxSizeMode.AutoSize\n        Me.Controls.Add(PictureBox1)\n    End Sub\nEnd Class