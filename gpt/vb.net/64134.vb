Sub ExportToCSV()\n        Dim ws As Worksheet\n        For Each ws In ThisWorkbook.Worksheets\n            ws.SaveAs "C:\path\to\export\" & ws.Name & ".csv", xlCSV\n        Next ws\n    End Sub