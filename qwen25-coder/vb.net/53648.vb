Public Class MyObject\n    Public Property Name As String\n    Public Property ID As Integer\n\n    Public Sub New(name As String, id As Integer)\n        Me.Name = name\n        Me.ID = id\n    End Sub\n\n    ' Override ToString method to display multiple properties\n    Public Overrides Function ToString() As String\n        Return $"{Name}, {ID}"\n    End Function\nEnd Class