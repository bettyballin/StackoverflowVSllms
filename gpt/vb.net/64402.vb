Public Class Form1\n\n    Private Sub Form1_Paint(sender As Object, e As PaintEventArgs) Handles MyBase.Paint\n        ' Create a pen to draw the line\n        Dim pen As New Pen(Color.Black, 2)\n\n        ' Draw a line from point (10, 10) to point (200, 200)\n        e.Graphics.DrawLine(pen, 10, 10, 200, 200)\n\n        ' Dispose the pen after use\n        pen.Dispose()\n    End Sub\n\nEnd Class