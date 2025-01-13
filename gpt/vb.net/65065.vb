Imports Excel = Microsoft.Office.Interop.Excel\n\nPublic Sub SortExcelColumn()\n    ' Create a new instance of Excel application\n    Dim excelApp As New Excel.Application\n    ' Open an existing workbook or create a new one\n    Dim workbook As Excel.Workbook = excelApp.Workbooks.Open("your_excel_file_path.xlsx")\n    ' Get the first worksheet (or the worksheet you want to work with)\n    Dim worksheet As Excel.Worksheet = CType(workbook.Sheets(1), Excel.Worksheet)\n\n    ' Define the range to sort\n    Dim sortRange As Excel.Range = worksheet.Range("A8:L100") ' Adjust the range as needed\n\n    ' Perform the sort\n    sortRange.Sort(Key1:=sortRange.Columns("L"), _\n                   Order1:=Excel.XlSortOrder.xlAscending, _\n                   Header:=Excel.XlYesNoGuess.xlYes, _\n                   Orientation:=Excel.XlSortOrientation.xlSortRows)\n\n    ' Save and close the workbook\n    workbook.Save()\n    workbook.Close()\n\n    ' Quit the Excel application\n    excelApp.Quit()\n\n    ' Release COM objects\n    ReleaseObject(sortRange)\n    ReleaseObject(worksheet)\n    ReleaseObject(workbook)\n    ReleaseObject(excelApp)\nEnd Sub\n\nPrivate Sub ReleaseObject(ByVal obj As Object)\n    Try\n        System.Runtime.InteropServices.Marshal.ReleaseComObject(obj)\n        obj = Nothing\n    Catch ex As Exception\n        obj = Nothing\n    Finally\n        GC.Collect()\n    End Try\nEnd Sub