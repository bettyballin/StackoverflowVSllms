Private Function theThing() As Integer\n    Dim ar() As Integer = {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1}\n    Dim arLenght As Integer = ar.GetUpperBound(0)\n    Dim result(ar.Length - 1) As Integer\n    Dim arCount As Integer = 0\n\n    For x As Integer = 0 To arLenght\n        If ar(x) = 1 Then\n            result(arCount) = x\n            arCount += 1\n        End If\n    Next\n\n    If arCount = 0 Then\n        Return -1 ' Return -1 if there are no 1s in the array\n    End If\n\n    Dim r As New Random()\n    Return result(r.Next(arCount))\nEnd Functio