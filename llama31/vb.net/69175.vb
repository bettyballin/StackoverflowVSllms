Public Class MyClass\n    Private _myField As String\n\n    Public Property MyProperty() As String\n        Get\n            Return _myField\n        End Get\n        Set(ByVal value As String)\n            _myField = value\n        End Set\n    End Property\n\n    Public Sub MyMethod(ByVal myParameter As String)\n        Dim myVariable As String = myParameter\n        ' Do something with myVariable\n    End Sub\nEnd Class