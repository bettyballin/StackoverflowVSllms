Imports Microsoft.Office.Interop.Word\nImports Microsoft.Office.Interop.Excel\nImports System.Runtime.InteropServices\n\nModule Module1\n    Sub Main()\n        Dim wordApp As New Microsoft.Office.Interop.Word.Application\n        Dim wordDoc As Microsoft.Office.Interop.Word.Document = wordApp.Documents.Add()\n        Dim excelApp As New Microsoft.Office.Interop.Excel.Application\n        Dim excelWorkbook As Microsoft.Office.Interop.Excel.Workbook = excelApp.Workbooks.Open("C:\path\to\your\excel.xlsx")\n        \n        ' Copy the Excel worksheet to clipboard\n        Dim excelSheet As Microsoft.Office.Interop.Excel.Worksheet = excelWorkbook.Sheets(1)\n        excelSheet.UsedRange.Copy()\n\n        ' Paste the Excel worksheet into the Word document\n        Dim range As Microsoft.Office.Interop.Word.Range = wordDoc.Range()\n        range.Paste()\n\n        ' Save the Word document\n        wordDoc.SaveAs2("C:\path\to\your\document.docx")\n        \n        ' Cleanup\n        wordDoc.Close()\n        wordApp.Quit()\n        excelWorkbook.Close(False)\n        excelApp.Quit()\n        \n        Marshal.ReleaseComObject(wordDoc)\n        Marshal.ReleaseComObject(wordApp)\n        Marshal.ReleaseComObject(excelWorkbook)\n        Marshal.ReleaseComObject(excelApp)\n    End Sub\nEnd Module