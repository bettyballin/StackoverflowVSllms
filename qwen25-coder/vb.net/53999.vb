Imports System.Drawing.Drawing2D\n\nPublic Class Form1\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Create a bitmap with the same size as the form\n        Dim bmp As New Bitmap(Me.ClientSize.Width, Me.ClientSize.Height)\n\n        ' Loop through each pixel and set its color\n        For x As Integer = 0 To bmp.Width - 1\n            For y As Integer = 0 To bmp.Height - 1\n                If (x + y) Mod 2 = 0 Then\n                    bmp.SetPixel(x, y, Color.Black)\n                Else\n                    bmp.SetPixel(x, y, Color.White)\n                End If\n            Next\n        Next\n\n        ' Create a graphics object from the bitmap\n        Using g As Graphics = Me.CreateGraphics()\n            g.DrawImage(bmp, New Point(0, 0))\n        End Using\n    End Sub\nEnd Class