Imports System.Windows.Forms\nImports System.Drawing\n\nPublic Class CustomBorderColorLabel\n    Inherits Label\n\n    Private _borderColor As Color = Color.Black ' Default border color is Black.\n\n    Public Property BorderColor() As Color\n        Get\n            Return _borderColor\n        End Get\n        Set(ByVal value As Color)\n            _borderColor = value\n            Me.Invalidate() ' Redraw control with the new color.\n        End Set\n    End Property\n\n    Protected Overrides Sub OnPaint(e As PaintEventArgs)\n        MyBase.OnPaint(e)\n        ' Draw the border using custom color.\n        e.Graphics.DrawRectangle(New Pen(_borderColor, 1), New Rectangle(0, 0, Me.Width - 1, Me.Height - 1))\n    End Sub\nEnd Class