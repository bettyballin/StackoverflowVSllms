Public Class MyForm\n    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load\n        ' Ensure the splitter handles the paint event\n        AddHandler Me.SplitterControl.Paint, AddressOf SplitterControl_Paint\n    End Sub\n\n    Private Sub SplitterControl_Paint(sender As Object, e As PaintEventArgs)\n        Dim s As Splitter = DirectCast(sender, Splitter)\n        Using p As Pen = New Pen(Color.Gray, 2)\n            ' Draw lines to create a grip pattern\n            If s.Dock = DockStyle.Left OrElse s.Dock = DockStyle.Right Then\n                For i As Integer = 10 To s.Width Step 10\n                    e.Graphics.DrawLine(p, i, 5, i, s.Height - 5)\n                Next\n            ElseIf s.Dock = DockStyle.Top OrElse s.Dock = DockStyle.Bottom Then\n                For i As Integer = 10 To s.Height Step 10\n                    e.Graphics.DrawLine(p, 5, i, s.Width - 5, i)\n                Next\n            End If\n        End Using\n    End Sub\nEnd Class