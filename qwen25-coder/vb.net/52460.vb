Public Function GetStatus(ByVal objStatus As Object) As Boolean\n    If objStatus Is DBNull.Value Then\n        Return False ' or whatever default state you prefer\n    ElseIf DirectCast(objStatus, Boolean) = True Then\n        Return True\n    Else\n        Return False\n    End If\nEnd Functio