Sub SaveSheetsToCSV()\n    Dim ws As Worksheet\n    Dim csvFile As String\n    \n    For Each ws In ThisWorkbook.Worksheets\n        csvFile = ThisWorkbook.Path & "\" & ws.Name & ".csv"\n        ws.SaveAs csvFile, xlCSV\n    Next ws\nEnd Sub