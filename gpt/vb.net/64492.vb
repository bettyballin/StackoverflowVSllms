Sub HideTable(tbl As Table)\n    ' Hide the content of each cell\n    Dim cel As Cell\n    For Each cel In tbl.Range.Cells\n        cel.Range.Font.Hidden = True\n    Next cel\n    \n    ' Collapse the table to remove gridlines and spacing\n    tbl.Rows.HeightRule = wdRowHeightExactly\n    tbl.Rows.Height = 1\n    tbl.Borders.Enable = False\nEnd Sub\n\nSub ShowTable(tbl As Table)\n    ' Show the content of each cell\n    Dim cel As Cell\n    For Each cel In tbl.Range.Cells\n        cel.Range.Font.Hidden = False\n    Next cel\n    \n    ' Restore the table's original height and borders\n    tbl.Rows.HeightRule = wdRowHeightAuto\n    tbl.Borders.Enable = True\nEnd Sub