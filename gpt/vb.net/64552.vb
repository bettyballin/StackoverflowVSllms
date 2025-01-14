Private Sub Worksheet_Change(ByVal Target As Range)\n    If Not Intersect(Target, Me.Range("A1")) Is Nothing Then\n        If Target.Value = "FillHere" Then\n            Call FillHere\n        End If\n    End If\nEnd Sub\n\nSub FillHere()\n    Dim rng As Range\n    Set rng = Me.Range("B1") ' Change to the range where you want to start filling\n    \n    rng.Cells(1, 1) = "HELLO"\n    rng.Cells(1, 2) = "WORLD"\nEnd Sub