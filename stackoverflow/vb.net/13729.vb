Public Class Sample\n    Private mValue As Integer\n    Default Public ReadOnly Property Test(ByVal index As Integer) As Integer\n      Get\n        Return index\n      End Get\n    End Property\n  End Class