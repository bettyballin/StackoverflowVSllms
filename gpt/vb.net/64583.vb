Sub FillHere()\n    Dim rng As Range\n    Set rng = Application.Caller\n    \n    ' Assuming you want to start filling from the cell where the cursor is\n    rng.Cells(1, 1) = "HELLO"\n    rng.Cells(1, 2) = "WORLD"\nEnd Sub