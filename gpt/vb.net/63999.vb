Public Function IsNullOrNothing(value As Object) As Boolean\n    If value Is Nothing Then\n        Return True\n    End If\n\n    If TypeOf value Is DBNull Then\n        Return True\n    End If\n\n    If TypeOf value Is Integer? Then\n        Dim nullableInt As Integer? = CType(value, Integer?)\n        If Not nullableInt.HasValue Then\n            Return True\n        End If\n    End If\n\n    ' Add checks for other nullable value types as needed\n    ' If TypeOf value Is Double? Then ...\n\n    Return False\nEnd Functio