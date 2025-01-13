Imports System.Windows\nImports System.Windows.Media\n\nPublic Class InsertionAdorner\n    Inherits Adorner\n\n    Private _line As LineGeometry\n\n    Public Sub New(element As UIElement)\n        MyBase.New(element)\n        _line = New LineGeometry()\n        _line.StartPoint = New Point(0, 0)\n        _line.EndPoint = New Point(10, 10)\n    End Sub\n\n    Protected Overrides Sub OnRender(drawingContext As DrawingContext)\n        drawingContext.DrawGeometry(Brushes.Black, New Pen(Brushes.Black, 1), _line)\n    End Sub\n\n    Public Sub UpdatePosition(position As Point)\n        _line.StartPoint = position\n        _line.EndPoint = New Point(position.X + 10, position.Y)\n        InvalidateVisual()\n    End Sub\nEnd Class