Public Class ClassB\n    Inherits ClassA\n\n    Public Shared Sub DoWork()\n        Dim instance As New ClassA()\n        Dim test As String = instance.SecurityKey\n        ' ...\n    End Sub\nEnd Class