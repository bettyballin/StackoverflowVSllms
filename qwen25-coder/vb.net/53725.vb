Public Class FancyLabel\n    Inherits Label\n\n    Public Sub New()\n        ' Enable double buffering to reduce flicker and GDI usage.\n        Me.SetStyle(ControlStyles.OptimizedDoubleBuffer, True)\n        Me.SetStyle(ControlStyles.UserPaint, True)\n        Me.SetStyle(ControlStyles.AllPaintingInWmPaint, True)\n    End Sub\n\n    Protected Overrides Sub OnPaint(ByVal e As System.Windows.Forms.PaintEventArgs)\n        e.Graphics.TextRenderingHint = Drawing.Text.TextRenderingHint.ClearTypeGridFit\n        MyBase.OnPaint(e)\n    End Sub\n\n    ' It's a good practice to override the Dispose method.\n    Protected Overrides Sub Dispose(disposing As Boolean)\n        If disposing Then\n            ' Dispose of managed resources if any.\n        End If\n        ' Call base class dispose method.\n        MyBase.Dispose(disposing)\n    End Sub\nEnd Class