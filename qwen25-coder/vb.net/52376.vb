Imports System.Drawing\n\nPublic Class Form1\n    Private Sub GroupBox1_Paint(sender As Object, e As PaintEventArgs) Handles GroupBox1.Paint\n        ' Draw a rounded rectangle for the groupbox border with transparency.\n        Dim rect = RectFrom(clientRectangle.GroupBox1)\n        ControlPaint.DrawBorderPath(e.Graphics,\n                                    rect, ButtonBorderStyle.Solid,\n                                    Color.White)\n\n        ' Fill group box background with transparent color\n        Using brush = New SolidBrush(Color.FromArgb(50, 255, 255, 255)) ' ARGB for transparency\n            e.Graphics.FillRectangle(brush, clientRectangle.GroupBox1)\n        End Using\n\n        ' Draw the text of the group box.\n        Dim sf As StringFormat = New StringFormat With {.LineAlignment = StringAlignment.Center}\n        Dim textRect As Rectangle = Rectangle.FromLTRB(rect.X + 5, rect.Top - (rect.Height / 2) - 3,\n                                                      rect.Width + 10, rect.Height)\n        Using b As Brush = New SolidBrush(GroupBox1.ForeColor)\n            e.Graphics.DrawString(GroupBox1.Text, GroupBox1.Font, b, textRect, sf)\n        End Using\n    End Sub\n\n    Private Function RectFrom(control As Control) As RectangleF\n        Dim grpRect = control.ClientRectangle\n        grpRect.Inflate(-2, -2)\n        Return grpRect\n    End Function\nEnd Class