Public Class Job\n    Implements ICloneable\n\n    Public Property Name As String\n\n    Public Function Clone() As Object Implements ICloneable.Clone\n        Return New Job With {.Name = Me.Name}\n    End Function\nEnd Class