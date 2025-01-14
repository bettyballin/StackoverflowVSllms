Public Class Form1\n    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click\n        Me.Invalidate()  ' Causes the Paint event to be called again.\n    End Sub\n\n    Protected Overrides Sub OnPaint(ByVal pe As PaintEventArgs)\n        MyBase.OnPaint(pe)\n\n        Dim g As Graphics = Me.CreateGraphics()\n        Dim height1 As Integer\n        Dim height2 As Integer\n\n        If Not Integer.TryParse(TextBox1.Text, height1) Then\n            MessageBox.Show("Please enter a valid integer for the first bar.")\n            Return\n        End If\n\n        If Not Integer.TryParse(TextBox2.Text, height2) Then\n            MessageBox.Show("Please enter a valid integer for the second bar.")\n            Return\n        End If\n\n        ' Simple horizontal bars drawn from left to right\n        Dim barWidth As Integer = 100\n        Dim spacing As Integer = 50\n        Dim startX As Integer = 50\n        Dim startY As Integer = 50\n\n        g.FillRectangle(Brushes.Blue, startX, startY, height1, barWidth)\n        g.DrawRectangle(Pens.Black, startX, startY, height1, barWidth)\n\n        g.FillRectangle(Brushes.Red, startX, startY + spacing + barWidth, height2, barWidth)\n        g.DrawRectangle(Pens.Black, startX, startY + spacing + barWidth, height2, barWidth)\n\n        ' Add labels if you want\n        g.DrawString("Bar 1", Me.Font, Brushes.Black, startX + height1 + 10, startY + (barWidth / 2) - (Me.Font.GetHeight() / 2))\n        g.DrawString("Bar 2", Me.Font, Brushes.Black, startX + height2 + 10, startY + spacing + barWidth + (barWidth / 2) - (Me.Font.GetHeight() / 2))\n\n        g.Dispose()\n    End Sub\nEnd Class