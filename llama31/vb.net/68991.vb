Imports Excel = Microsoft.Office.Interop.Excel\n\nDim xlApp As Excel.Application\nDim xlWorkbook As Excel.Workbook\nDim xlWorksheet As Excel.Worksheet\nDim notesRange As Excel.Range\nDim textHeight As Double\nDim pageBreak As Double\nDim newRange As Excel.Range\n\n' Initialize Excel objects\nxlApp = New Excel.Application\nxlWorkbook = xlApp.Workbooks.Open("your_workbook_path")\nxlWorksheet = xlWorkbook.Sheets("your_sheet_name")\nnotesRange = xlWorksheet.Range("A2:L36") ' Your named range\n\n' Calculate total text height\ntextHeight = notesRange.Height * (notesRange.Text.ToString.Length / notesRange.Width)\n\n' Get current page break\npageBreak = xlWorksheet.PageSetup.PrintArea.Height\n\n' Check if text exceeds page break\nIf textHeight > pageBreak Then\n    ' Create new named range below current one\n    newRange = xlWorksheet.Range(notesRange.Offset(notesRange.Rows.Count, 0).Address)\n    newRange.Name = "Notes_Continued"\n    newRange.Text = notesRange.Text.ToString.Substring(pageBreak)\n    \n    ' Repeat process until all text is accommodated\n    While newRange.Text.ToString.Length > newRange.Width\n        ' Create new named range below current one\n        newRange = xlWorksheet.Range(newRange.Offset(newRange.Rows.Count, 0).Address)\n        newRange.Name = "Notes_Continued_" & (newRange.Row - notesRange.Row)\n        newRange.Text = newRange Offset(newRange.Rows.Count, 0).Text.ToString.Substring(newRange.Width)\n    End While\nEnd If