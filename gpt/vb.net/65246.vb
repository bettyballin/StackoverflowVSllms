Imports Microsoft.Office.Interop.Word\n\nModule Module1\n    Sub Main()\n        Dim wordApp As New Application()\n        Dim wordDoc As Document = wordApp.Documents.Open("C:\path\to\your\document.docx")\n        \n        wordApp.Visible = True\n        ' Remember to release COM objects to avoid memory leaks\n        ' wordDoc.Close(False)\n        ' wordApp.Quit()\n        ' System.Runtime.InteropServices.Marshal.ReleaseComObject(wordDoc)\n        ' System.Runtime.InteropServices.Marshal.ReleaseComObject(wordApp)\n    End Sub\nEnd Module