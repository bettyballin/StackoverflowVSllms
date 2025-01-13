Public Class GenericList(Of T)\n    Private elements() As T\n    Private count As Integer\n\n    Public Sub New(ByVal capacity As Integer)\n        ReDim elements(capacity - 1)\n        count = 0\n    End Sub\n\n    Public Sub Add(ByVal element As T)\n        If count < elements.Length Then\n            elements(count) = element\n            count += 1\n        Else\n            ' Handle capacity overflow\n        End If\n    End Sub\n\n    Public Function GetElement(ByVal index As Integer) As T\n        If index < count Then\n            Return elements(index)\n        Else\n            ' Handle index out of range\n            Return Nothing\n        End If\n    End Function\nEnd Class