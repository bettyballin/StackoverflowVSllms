Imports Microsoft.Office.Interop.Excel\n\nModule Module1\n    Sub Main()\n        Dim excelApp As New Application()\n        excelApp.Visible = True\n        Dim workbook As Workbook = excelApp.Workbooks.Add()\n        workbook.Sheets(1).Cells(1, 1) = "Hello from Office 2007!"\n    End Sub\nEnd Module