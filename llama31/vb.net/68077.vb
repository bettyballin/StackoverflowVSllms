' Exit a For loop\nFor i As Integer = 0 To 10\n    If i = 5 Then\n        Exit For\n    End If\nNext\n\n' Exit a While loop\nDim i As Integer = 0\nWhile i <= 10\n    If i = 5 Then\n        Exit While\n    End If\n    i += 1\nEnd While\n\n' Exit a Do loop\nDim i As Integer = 0\nDo While i <= 10\n    If i = 5 Then\n        Exit Do\n    End If\n    i += 1\nLoop