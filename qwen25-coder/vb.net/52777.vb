Imports System.Drawing.Printing\n\nPublic Class Form1\n    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click\n        PrintForm()\n    End Sub\n\n    Private Sub PrintForm()\n        ' Create a Bitmap object of the form\n        Dim bmp As New Bitmap(Me.Width, Me.Height)\n        ' Draw this form's graphics to the bitmap\n        Me.DrawToBitmap(bmp, New Rectangle(0, 0, Me.Width, Me.Height))\n\n        ' Create a new PrintDocument\n        Dim pd As New PrintDocument()\n        AddHandler pd.PrintPage, Sub(sndr As Object, ev As PrintPageEventArgs)\n                                     ' Draw our bitmap to the printer\n                                     ev.Graphics.DrawImage(bmp, Point.Empty)\n                                 End Sub\n\n        ' Show print dialog and send document to printer if user chooses to print\n        Dim pdi As New PrintDialog()\n        pdi.Document = pd\n        If pdi.ShowDialog() = DialogResult.OK Then\n            pd.Print()\n        End If\n    End Sub\nEnd Class