Public Function MyMethod(ByVal param1 As Integer, _\n    Optional ByVal param2 As Integer = 0, _\n    Optional ByVal param3 As Integer = 1) As Integer\n\n    ' Translated to:\n    Public Function MyMethod(ByVal param1 As Integer, _\n        ByVal ParamArray params() As Object) As Integer\n\n        Dim param2 As Integer = 0\n        Dim param3 As Integer = 1\n\n        If params IsNot Nothing AndAlso params.Length > 0 Then\n            param2 = CInt(params(0))\n            If params.Length > 1 Then\n                param3 = CInt(params(1))\n            End If\n        End If\n\n        Return param1 + param2 + param3\n    End Functio