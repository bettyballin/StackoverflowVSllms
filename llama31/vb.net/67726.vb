Sub ExportAllWorksheets()\n    Dim originalWorkbook As Excel.Workbook = ThisWorkbook\n    Dim worksheet As Excel.Worksheet\n    \n    For Each worksheet In originalWorkbook.Worksheets\n        Dim newFilePath As String = "C:\Path\To\New\Workbook_" & worksheet.Name & ".xlsx"\n        ExportWorksheet worksheet, newFilePath\n    Next worksheet\nEnd Sub