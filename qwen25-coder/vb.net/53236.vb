Imports System.Collections.Generic\n\nModule Module1\n    Sub Main()\n        Dim startDate As DateTime = #2023/10/01#\n        Dim endDate As DateTime = DateTime.Now\n        Dim holidays As New List(Of DateTime) From {\n            #2023/11/24#,  ' Thanksgiving\n            #2023/12/25#   ' Christmas\n        }\n\n        Dim workingDays As Integer = CountWorkingDays(startDate, endDate, holidays)\n        Console.WriteLine("Number of working days: " & workingDays)\n    End Sub\n\n    Function CountWorkingDays(ByVal startDate As DateTime, ByVal endDate As DateTime, ByVal holidays As List(Of DateTime)) As Integer\n        Dim count As Integer = 0\n        For currentDate As DateTime = startDate To endDate\n            If currentDate.DayOfWeek <> DayOfWeek.Saturday AndAlso\n               currentDate.DayOfWeek <> DayOfWeek.Sunday AndAlso\n               Not holidays.Contains(currentDate.Date) Then\n                count += 1\n            End If\n        Next\n        Return count\n    End Function\nEnd Module