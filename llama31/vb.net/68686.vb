If CurCheckedItems.Count <> OldCheckedItems.Count Then\n    ' There's a difference\nElse\n    For i As Integer = 0 To CurCheckedItems.Count - 1\n        If CurCheckedItems(i) IsNot OldCheckedItems(i) Then\n            ' There's a difference\n            Exit For\n        End If\n    Next\nEnd If