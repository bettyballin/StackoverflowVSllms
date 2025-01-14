Public Class MyLibraryClass\n    ' This method can be accessed by anyone using this class\n    Public Function PublicMethod() As String\n        Return "This is visible."\n    End Function\n\n    ' This property can only be accessed within MyLibraryClass itself\n    Private Property PrivateProperty As Integer\n\n    ' This method can only be accessed within MyLibraryClass itself\n    Private Sub PrivateMethod()\n        ' Private logic here\n    End Sub\nEnd Class