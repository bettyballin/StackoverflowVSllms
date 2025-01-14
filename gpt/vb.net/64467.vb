Imports System.IO\n\nPublic Class Form1\n    ' Assuming you have 16 PictureBox controls on your form named PictureBox1, PictureBox2, ..., PictureBox16\n    Private PictureBoxes As PictureBox()\n\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Initialize the PictureBox array\n        PictureBoxes = New PictureBox() {PictureBox1, PictureBox2, PictureBox3, PictureBox4, PictureBox5, PictureBox6, PictureBox7, PictureBox8, PictureBox9, PictureBox10, PictureBox11, PictureBox12, PictureBox13, PictureBox14, PictureBox15, PictureBox16}\n    End Sub\n\n    Private Sub DisplayImage(value As Integer)\n        If value < 1 Or value > 52 Then\n            Throw New ArgumentOutOfRangeException("value", "Value must be between 1 and 52.")\n        End If\n\n        Dim imagePath As String = Path.Combine(Application.StartupPath, $"image{value}.gif")\n\n        If Not File.Exists(imagePath) Then\n            Throw New FileNotFoundException("Image file not found.", imagePath)\n        End If\n\n        For Each pb As PictureBox In PictureBoxes\n            pb.Image = Image.FromFile(imagePath)\n        Next\n    End Sub\nEnd Class