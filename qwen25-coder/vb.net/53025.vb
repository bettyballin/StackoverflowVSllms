Public Class GenericStat\n    Public Property Value() As Integer\n\n    Public Overrides Function ToString() As String\n        Return Me.Value.ToString()\n    End Function\nEnd Class