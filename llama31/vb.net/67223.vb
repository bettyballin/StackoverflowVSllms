Dim reportList As New ArrayList()\nreportList.Add(New Report() With {.ReportCode = "1", .ReportName = "Report 1"})\nreportList.Add(New Report() With {.ReportCode = "2", .ReportName = "Report 2"})\nreportList.Add(New Report() With {.ReportCode = "6", .ReportName = "Report 6"})\n\nDim reportToFind As String = "6"\nDim index As Integer = ReportFinder.FindReport(reportList, reportToFind)\n\nIf index >= 0 Then\n    Console.WriteLine("Report found at index " & index)\nElse\n    Console.WriteLine("Report not found")\nEnd If