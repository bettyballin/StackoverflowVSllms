Private Sub SomeFunction(ByVal PassedArray() As String)\n    For i As Integer = 0 To PassedArray.Length - 1 ' Use Length instead of Count for arrays\n        Debug.WriteLine(PassedArray(i))\n    Next\nEnd Sub\n\nPublic Sub Test()\n    ' Initialize and pass the array directly\n    SomeFunction(New String() {"some", "array", "members"})\nEnd Sub