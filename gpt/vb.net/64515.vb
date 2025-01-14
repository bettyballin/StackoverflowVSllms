Function JoinNonNullElements(ParamArray elements() As Variant) As String\n    Dim result As String\n    Dim i As Integer\n    \n    result = ""\n    \n    For i = LBound(elements) To UBound(elements)\n        If Not IsNull(elements(i)) And elements(i) <> "" Then\n            If result <> "" Then\n                result = result & " - "\n            End If\n            result = result & elements(i)\n        End If\n    Next i\n    \n    JoinNonNullElements = result\nEnd Function\n\n' Usage example\nMe.Title.Value = JoinNonNullElements([Conference], [Speaker], partstr)