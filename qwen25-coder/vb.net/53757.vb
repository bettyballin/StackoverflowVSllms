Dim today As DateTime = DateTime.Today\nDim startOfYear As DateTime = New DateTime(today.Year, 1, 1)\n\n' If you want to get the difference in days between today and the start of the year:\nDim daysDifference As Integer = (today - startOfYear).Days\n\nConsole.WriteLine("Start of Year: " & startOfYear.ToString("d"))\nConsole.WriteLine("Days since start of year: " & daysDifference)